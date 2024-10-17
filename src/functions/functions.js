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


/**
 * Заменяет все точки и запятые в строке на пробелы.
 *
 * @param {string} input - Входная строка, в которой будут произведены замены.
 * @returns {string} - Изменённая строка, в которой точки и запятые заменены пробелами.
 */
function replaceDotsAndCommas(input) {
    // Используем _.map из библиотеки underscore для перебора символов и замены точек и запятых
    return _.map(input, function (char) {
        return char === '.' || char === ',' ? ' ' : char;
    }).join('');
}