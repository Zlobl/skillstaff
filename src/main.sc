require: requirements.sc
    
init:

    
  $global.$ = {
        __noSuchProperty__: function(property) {
            return $jsapi.context()[property];
        }
    };


    /* Чистим клиентский запрос от ',', '.' */
    bind("preMatch", function($context) {
        if ($context.request && $context.request.query){
            $context.request.query = replaceDotsAndCommas($context.request.query);
        }
    });


    /* Для более короткого обращени к инжектору в функциях */
    bind("preMatch", function($) {
        $.session.KEY_API = $.injector.api.keyAPI; // ключи для внешних запросов
        $.session.API = $.injector.api.host; // эндпойнты для запросов
    });

    /* Пишем историю стейтов*/
    bind("preProcess", function($context) {
        var $session = $.session;
        $session.historyState = $session.historyState ? $session.historyState : [];
        $session.historyState.push($context.currentState);
    });

    /* Обрабатывает обрботчик onScriptError */
    bind("onScriptError", function($context) {
        $reactions.answer('Что-то сломалось, причина: ');
        $reactions.answer(JSON.stringify($context.exception.message));
    });


theme: /

    state: LengthLimit
        event!: lengthLimit
        a: Упс, кажется это слишком длинный текст, попробуй что-то сказать по короче