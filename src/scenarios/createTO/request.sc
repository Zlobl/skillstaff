
theme: /Request


    # хочу записаться на первое ТО
    # запиши меня на техобслуживание
    # как пройти ТО-1
    # тех обслуживание пройти у вас можно? пройти ТО автомобиль шкода
    # техоб надо пройти подошло время ТО 12
    state: ask_signUpTo
        q!:  хочу записаться на первое ТО, меня завут Антипов Максим
        script: 
            $reactions.answer(JSON.stringify(parseTree));

            /*

            фио, 
            номер, 
            модель

            


            Прикзнак того, что есть фио 
               если в запросе есть одна из 3-х сущностей, то ФИО есть. 
                В ответе указываем  @mystem.famn +  @pymorphy.name + @mystem.patrn

            Если известные 2 агрумента, то конец

            Иначе, доспрашиваем один из недостоющих аргументов
                Доспрашиваем нужные аргументы

            */




        if: ($session.phone && $session.name) || ($session.phone && $session.car)
            a: Оформляю заявку на техобслуживание.
            a: Наш сотрудник свяжется с вами по номеру "{{$session.phone}}" и уточнит время.
            a: {{$session.car}} {{$session.name}}




        else: 
            a: Для записи на ТО уточните, пожалуйста, ваше имя, номер телефона и марку автомобиля.
                
        state: SignToClarification
            q: $CarBrand
            q: *
            script: 
                var entities = $jsapi.context().entities
                if (!$session.name){
                    $.session.name = _.filter(entities, function(en) {
                                        return en.pattern == "pymorphy.name";
                                            }).map(function(en) {
                                                return en.value;
                    });
                    if (_.isEmpty($.session.name)) delete  $.session.name;
                }
                if (!$session.phone){
                    $.session.phone = _.filter(entities, function(en) {
                    return en.pattern == "duckling.phone-number";
                    }).map(function(en) {
                    return en.value;
                    });
                    if (_.isEmpty($.session.phone)) delete  $.session.phone;
                }
                //TODO: здесь надо подобрать паттерн по парстри так же как с именем
                if (!$session.car){
                    var puttetn = $jsapi.context().nluResults.selected.debugInfo
                    if (puttetn && puttetn.pattern && puttetn.effectivePattern && (puttetn.pattern == "$carEan" || puttetn.pattern == "$carRus")){
                        $.session.car = puttetn.effectivePattern
                        $reactions.answer(JSON.stringify($session.car))
                    }
                }
            if: ($session.phone && $session.name) || ($session.phone && $session.car)
                go!: /SignUpTo
            else:
                go!: /SignToClarification2
        
        
    state: SignToClarification2
        script:
            if ($.session.name && !$.session.phone && !$session.car){
                $reactions.answer($.session.name + ", уточните номер телефона и марку автомобиля.");
            }else if(!$.session.name && $.session.phone && !$session.car){
                $reactions.answer("Уточните ваше имя и марку автомобиля.");
            }else if(!$.session.name && !$.session.phone && $session.car){
                $reactions.answer("Уточните ваше имя и номер телефона.");
            }else if($.session.name && !$.session.phone && $session.car){
                $reactions.answer("Для записи уточните ваш номер телефона.");
            }else { $reactions.answer("Для записи на ТО уточните ваше имя, номер телефона и марку автомобиля."); }
            $reactions.transition( {value: "/SignUpTo/SignToClarification", deferred: true} );
            
        # state: GoSignToClarification
        #     q: *
        #     go!: /SignUpTo/SignToClarification
            
            
    state: DeleteSession
        q!: deletesession
        script:
            $jsapi.stopSession();

        
    state: Match
        event!: match
        a: {{$context.intent.answer}}



    # state:
    #     q!: $test
    #     q!: *
        
    #     script:
    #         var text = "Денис, номер телефона 89965008843, машина Ксиоми"
    #         $reactions.answer(JSON.stringify($jsapi.context().nluResults.selected.debugInfo))