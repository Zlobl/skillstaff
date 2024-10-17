
theme: /Request



    # хочу записаться на первое ТО
    # запиши меня на техобслуживание
    # как пройти ТО-1
    # тех обслуживание пройти у вас можно? пройти ТО автомобиль шкода
    # техоб надо пройти подошло время ТО 12
    state: ask_signUpTo
        q!: * $signUp *
        script: 
            // проверка номера телефона
            var phone =  extractDigits($parseTree.text);
            if (phone)  $client.phone =  validatePhoneNumber(phone) ?  phone: null;
            // Проверка ФИО 
            //INFO: Реализовали возможность, подобрать ФИО ещё раз, 
            if ($parseTree["_signUp"] && $parseTree["_signUp"]["fio"])  $client.fio =  $parseTree["_signUp"]["fio"];
            // Проверка Авто
            if ($parseTree["_signUp"] && $parseTree["_signUp"]["auto"])  $client.auto =  $parseTree["_signUp"]["auto"];
            // Обязательно отлавливаем телефон, т.к. без него сотрудник не свяжется
            if (($client.fio && $client.phone) || ($client.auto && $client.phone)) $reactions.transition({value: "/Response/answer_signUpTo", deferred: false});
            else   $reactions.transition({value: "/Response/answer_signToClarification", deferred: false});



        state: ask_signUpToContext
            q: * $signUpContext *
            script:
                var phone =  extractDigits($parseTree.text);
                if (phone)  $client.phone =  validatePhoneNumber(phone) ?  phone: null;
                // Проверка ФИО 
                //INFO: Реализовали возможность, подобрать ФИО ещё раз, 
                if ($parseTree["_signUpContext"] && $parseTree["_signUpContext"]["fio"])  $client.fio =  $parseTree["_signUpContext"]["fio"];
                // Проверка Авто
                if ($parseTree["_signUpContext"] && $parseTree["_signUpContext"]["auto"])  $client.auto =  $parseTree["_signUpContext"]["auto"];
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
