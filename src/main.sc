require: requirements.sc

patterns:

    $GreaterZero = $regexp<[1-9]\d*> || converter = $converters.numberConverterDigit
    $customNumber = ( $NumberOneDigitNatural| $NumberTwoDigit |  $NumberDozen ) || converter = $converters.numberConverterSum
    $customNumberZero = (нол*|нул*|zero|0):0 || converter = $converters.numberConverterValue
    $cityOrDate = {[* @duckling.date *][* $City *]}
    $day = (({[$customNumber | $GreaterZero] (*день|*дней*|*дня*|*сут*)})| $customNumber | $GreaterZero )
    $week = {[$customNumber | $GreaterZero] *недел* }  
    $month = {[$customNumber | $GreaterZero] *месяц* } 
    $year = {[$customNumber | $GreaterZero] (*год*|*лет*) } 
    $periodToDay = ({[* $day *] [* $month *] [* $week *] [* $year *]}) || converter = convertToDays
    $pastDate = (* @duckling.date *)
    $curentFutureDate = (* @duckling.date *)
    $oneWord = $regexp<\pL{1,}> 
    $name = ({* @mystem.persn * [@mystem.famn]} | ($oneWord $oneWord $oneWord))
    $rejection = { [* @неХочу *] [* @зачем *] [* @неЗнаю *] }
    $futureTime = {({*след* (* $day *|* $month *|* $week *|* $year *)})} || converter = convertToDays


    
    
init:

    
  $global.$ = {
        __noSuchProperty__: function(property) {
            return $jsapi.context()[property];
        }
    };

    /* Для более короткого обращени к инжектору в функциях */
    bind("preMatch", function($) {
        $.session.KEY_API = $.injector.api.keyAPI; // ключи для внешних запросов
        $.session.API = $.injector.api.host; // эндпойнты для запросов
    });

    /* Меняем приоритет паттернов ($pastDate или $curentFutureDate) */
    bind("selectNLUResult", selectedPatterns);

    /* Пишем историю стейтов*/
    bind("preProcess", function($context) {
        var $session = $.session;
        $session.historyState = $session.historyState ? $session.historyState : [];
        $session.historyState.push($context.currentState);
    });

    /* Переводим состояние в стейт, если срабатывает обрботчик onScriptError */
    bind("onScriptError", function($context) {
        $reactions.answer('Ух бля, что-то сломалось');
        $reactions.answer(JSON.stringify($context.exception.message));
    });
