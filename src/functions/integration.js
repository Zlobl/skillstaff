/**
 * Записываем статус  в google таблицу
 * @param {String} [sheetsName] - имя таблицы
 * @returns 
 */

function googleAppendStatus(phone, fio, auto) {

    var IntegrationId = configGoogle.IntegrationId;
    var spreadsheetId = configGoogle.spreadsheetId;

    var status = configGoogle.status;

    var body = {
        "range": status + "!A1:C15",

        "values": [[phone, fio, auto]]
    }
    $integration.customRequest(
        IntegrationId,
        "https://sheets.googleapis.com/v4/spreadsheets/" + spreadsheetId + "/values/" + status + "!A1:C15:append" + "?valueInputOption=RAW",
        "POST",
        null,
        body
    );

}