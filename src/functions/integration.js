/**
 * Сервис получения погоды, метод https://openweathermap.org/api/forecast30
 * 
 * * @author Antipov Roman telegram: @antip91r
 * @param {Object} params - параметры
 * @property {String} params.lat - Latitude
 * @property {String} params.lon - Longitude
 * @returns {Object|null} - Объект с данными о погоде | null в случае ошибки   
 */
function getWeather(params) {
    var $session = $.session;
    var res = $http.get($session.API.openweathermap, {
        headers: {
            "accept": "application/json",
        },
        query: {
            lat: params.lat,
            lon: params.lon,
            key: $session.KEY_API.openweathermap,

        }
    })
    if (res && res.isOk) return res.data;
    return null;
}