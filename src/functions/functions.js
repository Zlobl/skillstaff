/**
 *  Конвертер для паттерна $periodToDay и $nextPeriod
 * 
 * @author Antipov Roman telegram: @antip91r
 * @param {Object} context - объект контекста диалога (опционально)
 * @returns {Number} Number - количество дней в parseTree
 */
function convertToDays(parseTree) {

    var day = !_.isUndefined(parseTree.day) ? (_.isUndefined(parseTree.day[0].value) ? 1 : parseTree.day[0].value) : 0;
    var week = !_.isUndefined(parseTree.week) ? (_.isUndefined(parseTree.week[0].value) ? 7 : parseTree.week[0].value * 7) : 0;
    var month = !_.isUndefined(parseTree.month) ? (_.isUndefined(parseTree.month[0].value) ? 31 : parseTree.month[0].value * 31) : 0;
    var year = !_.isUndefined(parseTree.year) ? (_.isUndefined(parseTree.year[0].value) ? 365 : parseTree.year[0].value * 365) : 0;

    return day + week + month + year

}



/**
 * Преобразует каждое слово строки, делая первую букву заглавной.
 *
 * @param {string} input - Строка, содержащая слова для преобразования.
 * @returns {string} Строка с заглавными первыми буквами каждого слова.
 */
function capitalizeWords(input) {
    var words = input.split(' ');
    var capitalizedWords = _.map(words, function (word) {
        return word.charAt(0).toUpperCase() + word.slice(1).toLowerCase();
    });
    return capitalizedWords.join(' ');
}




function getAutoEndName(parseTree) {
    
    var p = parseTree;
    var fio = false;
    var auto = false;
    if (!_.isUndefined(p["fio"])) fio = capitalizeWords(p["fio"][0]["text"]);
    if (!_.isUndefined(p["CarBrand"])) auto = p["CarBrand"][0]["value"].name;
    return { 'fio': fio, 'auto': auto }; 

}




/**
 *  Удаляем объекты из $context.session
 * 
 * @author Antipov Roman telegram: @antip91r
 * @param {Array} массив с наименованием объектов которые нужно удалить
 * @param {Object} context - объект контекста диалога (опционально)
 */
function deleteSessionObject(objArray, cnt) {
    var $ = cnt || $jsapi.context();
    _.each(objArray, function (name) {
        delete $.session[name]
     });

}

/**
 * Валидирует номер телефона.
 * 
 * Функция проверяет, начинается ли номер телефона с "+7" или "8" и состоит ли он ровно из 11 цифр.
 *
 * @param {string} phoneNumber - Номер телефона для валидации.
 * @returns {boolean} - Возвращает true, если номер телефона валиден, иначе false.
 */
function validatePhoneNumber(phoneNumber) {
    // Удаляем все символы, кроме цифр
    var cleanedPhoneNumber = phoneNumber.replace(/\D/g, '');

    // Проверяем, начинается ли номер с +7 или 8, и состоит ли он из 11 цифр
    if (phoneNumber.startsWith('7') || phoneNumber.startsWith('8')) {
        return cleanedPhoneNumber.length === 11;
    }
    return false;
}

/**
 * Возвращает подстроку, содержащую цифры, если такая подстрока существует.
 * Если подстроки с цифрами нет, возвращает null.
 * 
 * @param {string} str - Входная строка для поиска подстроки с цифрами.
 * @returns {string|null} - Подстрока с цифрами или null, если такой подстроки нет.
 */
function extractDigits(str) {
    // Используем регулярное выражение для поиска подстроки с цифрами
    var match = str.match(/\d+/);

    // Если нашли подстроку с цифрами, возвращаем её, иначе возвращаем null
    return _.isNull(match) ? null : match[0];
}


/**
 * Извлекает строку с Фамилией, Именем и Отчеством из объекта данных.
 * Ищет фамилию в "pymorphy.surn", имя в "pymorphy.name", отчество в "pymorphy.patr".
 * 
 * @param {Object} data - Объект с данными, содержащий информацию о ФИО.
 * @returns {string} Конкатенированная строка Фамилия Имя Отчество (если отчество есть).
 */
function getFioString(data) {
    // Проверяем, что объект содержит необходимые поля
    if (!data) {
        return '';
    }

    // Извлекаем фамилию, имя и отчество с использованием underscore
    var surname = _.chain(data["pymorphy.surn"])
        .pluck('value')
        .first()
        .value() || '';

    var name = _.chain(data["pymorphy.name"])
        .pluck('value')
        .first()
        .value() || '';

    var patr = _.chain(data["pymorphy.patr"])
        .pluck('value')
        .first()
        .value() || '';

    // Конкатенируем Фамилию, Имя и Отчество, игнорируя пустые значения
    return { "name": _.compact([surname, name, patr]).join(' ') };
}
