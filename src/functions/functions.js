

/**
 * Функция принимает число и возвращает число +   проспряженное  слово "человек" в зависимости от числа.
 *
 * @author Antipov Roman telegram: @antip91r
 * @param {number} number - Число, для которого необходимо определить форму слова "человек".
 * @returns {string} - Строка с проспрягнутым словом "человек".
 */
function getHumanString(number) {
    var positiveNumber = Math.abs(number); // получаем положительное значение числа

    if (positiveNumber % 10 === 1 && positiveNumber % 100 !== 11) {
        return " человек";
    } else if (positiveNumber % 10 === 2 && positiveNumber % 100 !== 12 ||
        positiveNumber % 10 === 3 && positiveNumber % 100 !== 13 ||
        positiveNumber % 10 === 4 && positiveNumber % 100 !== 14) {
        return " человека";
    } else {
        return " человек";
    }
}


/**
 * Счётчик попадений в стейт подряд
 * Если количество попадений >= N, то возвращает true и удаляет историю переходов между стейтами в $session.historyState
 * Если количество попадений < N, то возвращает false
 * 
 * @author Antipov Roman telegram: @antip91r
 * @param {number} number - количество попадений в стейтд подряд
 * @returns {boolean} - true || false
 */
function getStateCounterInARow(number) {

    var numberSlice = number * (-1);
    var $ = $jsapi.context();
    var sliceHistory = _.uniq($.session.historyState.slice(numberSlice));

    if ($.session.historyState.length >= number && sliceHistory.length == 1 && sliceHistory[0] == $.currentState) {
        $.session.historyState = [];
        return true;
    }
    return false;

}


/**
 * Функция возвращает детальную инфу по городу
 * 
 * @author Antipov Roman telegram: @antip91r
 * @param {string} nameCity - город  
 * @returns {Object|null} object|null  - объект с доп. инфой или null, если аргумент не явялется городом
 * @property {string} object.name - город
 * @property {string} object.lat - Longitude
 * @property {string} object.lon - Latitude
 * @property {string} object.country - код страны
 * @property {string} object.timezone - таймзона 
 * @property {string} object.population - популяция
 * @property {string} object.capital - капитал
 * @property {string} object.continent - континент
 */
function getCityInfo(nameCity) {
    var cityValue = null;

    _.each($Cities, function (item) {
        var alternateNames = [];
        _.each(item.alternateNames, function (names) {
            alternateNames.push(names.toLowerCase())
        });
        if (_.contains(alternateNames, nameCity.toLowerCase())) {
            cityValue = item.value;
            return false;  // Преждевременно завершаем цикл
        }
    });
    return cityValue;
}


/**
 * Функция возвращает стейт в обработчик selectNLUResult
 * 
 * @author Antipov Roman telegram: @antip91r
 * @param {Object} context - объект контекста диалога (опционально)
 * @returns {Object} object - объект выбранного интента
 */
function selectedPatterns(cnt) {

    var $ = cnt || $jsapi.context();

    var state = _.map($.nluResults.patterns, function (st) { return st.clazz });

    // проверяем, что в $context.nluResults.patterns находятся необходимые стейты
    var result = _.some(state, function (item) {
        return _.includes(['/AskStartDate/Date', '/AskStartDate/CatchAll'], item);
    });

    if (result && $.nluResults.patterns[0].pt["_duckling.date"] && $.nluResults.patterns.length === 2) {
        var date = $.nluResults.patterns[0].pt["_duckling.date"].value
        
        if (!moment(date).add(1, 'd').isSameOrAfter($jsapi.currentTime())) {
            $.nluResults.selected = _.find($.nluResults.patterns, function (st) {
                return st.clazz == '/AskStartDate/CatchAll'
            })
        } else {
            $.nluResults.selected = _.find($.nluResults.patterns, function (st) {
                return st.clazz == '/AskStartDate/Date'
            })

        }
    }
}


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




function test(parseTree) {
    
    var p = parseTree;

    var fio;
    var phone;
    var auto;

    log('[+++] 🧠🧠🧠 surn = ' + toPrettyString(parseTree));
    

    if (!_.isUndefined(p["pymorphy.surn"])
        && !_.isUndefined(p["pymorphy.name"])
        && !_.isUndefined(p["pymorphy.patr"])) {

        fio = [p["pymorphy.surn"][0].value, p["pymorphy.name"][0].value, p["pymorphy.patr"][0].value].join(' ')
    }
    


    /* Находим ФИО. 
    Если найдена фамилия (и/или) имя (и/или) отчество, то группируем значения в строку 
     */




    return { 'fio': fio, 'test2': 1}; 

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
