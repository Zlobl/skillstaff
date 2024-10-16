require: requirements.sc
    
init:

    
  $global.$ = {
        __noSuchProperty__: function(property) {
            return $jsapi.context()[property];
        }
    };

    bind("selectNLUResult", function($context) {
        // Для отладки выведем результаты в лог.
        log('[+++] 🧠🧠🧠 nluResults = ' + toPrettyString($context.nluResults));
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

    /* Переводим состояние в стейт, если срабатывает обрботчик onScriptError */
    bind("onScriptError", function($context) {
        $reactions.answer('Ух бля, что-то сломалось');
        $reactions.answer(JSON.stringify($context.exception.message));
    });


