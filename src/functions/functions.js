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




function test(parseTree) {
    
    var p = parseTree;


    log('[+++] 🧠🧠🧠 parseTree = ' + toPrettyString(parseTree));

    var fio = false;
    var phone = false;
    var auto = false;


    
    /* Находим ФИО. 
    Если найдена фамилия (и/или) имя (и/или) отчество, то группируем значения в строку 
     */

    if (!_.isUndefined(p["fio"])) fio = capitalizeWords(p["fio"][0]["text"]);
    if (!_.isUndefined(p["_duckling.number"])) phone = validatePhoneNumber(p["_duckling.number"]) ? p["_duckling.number"] : false; 


    //if (!_.isUndefined(p["signUpTo"]) && p["signUpTo"][0]["CarBrand"]) auto =  p["signUpTo"][0]["CarBrand"][0]["value"]["name"]





    return { 'fio': fio, 'auto': auto, 'phone': phone }; 

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
    var cleanedPhoneNumber = _.filter(phoneNumber, function (char) {
        return /\d/.test(char);
    }).join('');

    // Проверяем, начинается ли номер с +7 или 8, и состоит ли он из 11 цифр
    if (_.startsWith(phoneNumber, '+7') || _.startsWith(phoneNumber, '8')) {
        return cleanedPhoneNumber.length === 11;
    }
    return false;
}