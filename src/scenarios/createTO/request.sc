
theme: /Request




    # TODO: должен быть предусмотрен минимальный препроцессинг запросов пользователя (отсеивание слишком длинных запросов, очистка запроса от мусорных символов, которые теоретически могут помешать работе матчера)


    # хочу записаться на первое ТО
    # запиши меня на техобслуживание
    # как пройти ТО-1
    # тех обслуживание пройти у вас можно? пройти ТО автомобиль шкода
    # техоб надо пройти подошло время ТО 12
    state: ask_signUpTo
        # q!: * ($signUpTo/$signUpfio/$signUpCar) *
        q!: * $signUp *
        # q!:  * хочу записаться на первое ТО, меня завут Антипов Максим * 
        script: 
            // проверка номера телефона
            # $client = $client || {}
            var phone =  extractDigits($parseTree.text);
            if (phone)  $client.phone =  validatePhoneNumber(phone) ?  phone: null;
            // Проверка ФИО 
            //TODO: если есть в других сценариях, то ФИО подтягивает из $client.fio
            if ($parseTree["_signUp"] && $parseTree["_signUp"]["fio"])  $client.fio =  $parseTree["_signUp"]["fio"];
            // Проверка Авто
            if ($parseTree["_signUp"] && $parseTree["_signUp"]["auto"])  $client.auto =  $parseTree["_signUp"]["auto"];
            // Обязательно отлавливаем телефон, т.к. без него сотрудник не свяжется
            if (($client.fio && $client.phone) || ($client.auto && $client.phone)) $reactions.transition({value: "/Response/answer_signUpTo", deferred: false});
            else   $reactions.transition({value: "/Response/answer_signToClarification", deferred: false});



            
    state: DeleteSession
        q!: deletesession
        script:
            $jsapi.stopSession();
            delete $client.phone
            delete $client.fio
            delete $client.auto
