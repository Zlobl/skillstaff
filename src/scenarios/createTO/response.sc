theme: /Response


    state: answer_signUpTo
        a: Оформляю заявку на техобслуживание на следующие данные:
        script:
            if($client.fio) $reactions.answer("- " + $client.fio)
            if($client.phone) $reactions.answer("- телефон " + $client.phone)
            if($client.auto) $reactions.answer("- автомобиль " + $client.auto)
        a: Наш сотрудник свяжется с вами и уточнит время.
        
    state: answer_signToClarification
        a: Для оформления заявки, уточните следующие данные:
        script:
            if(!$client.fio) $reactions.answer("- ваше ФИО")
            if(!$client.phone) $reactions.answer("- телефон")
            if(!$client.auto) $reactions.answer("- марка автомобиля")
        go: /Request/ask_signUpTo