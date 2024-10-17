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
 * Записываем статус  в google таблицу
 * @param {String} [sheetsName] - имя таблицы
 * @returns 
 */

function googleAppendStatus(phone, fio, auto) {

    var IntegrationId = configGoogle.IntegrationId;
    var spreadsheetId = configGoogle.spreadsheetId;

    var body = {
        "range": googleHistoty + "!A1:C15",

        "values": [[ phone, fio, auto ] ]
    }
    $integration.customRequest(
        IntegrationId,
        "https://sheets.googleapis.com/v4/spreadsheets/" + spreadsheetId + "/values/" + googleHistoty + "!A1:C15:append" + "?valueInputOption=RAW",
        "POST",
        null,
        body
    );

}