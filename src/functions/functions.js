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

    var fio;
    var phone;
    var auto = null;


    
    /* Находим ФИО. 
    Если найдена фамилия (и/или) имя (и/или) отчество, то группируем значения в строку 
     */

    if (!_.isUndefined(p["fio"])) fio = capitalizeWords(p["fio"][0]["text"]);
    //if (!_.isUndefined(p["signUpTo"]) && p["signUpTo"][0]["CarBrand"]) auto =  p["signUpTo"][0]["CarBrand"][0]["value"]["name"]





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
