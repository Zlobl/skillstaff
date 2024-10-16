theme: /Response


    state: answer_signUpTo
        a: Оформляю заявку на техобслуживание на следующие данные:
        script:
            if($client.listTo.fio) $reactions.answer("- " + $client.listTo.fio)
            if($client.listTo.phone) $reactions.answer("- телефон " + $client.listTo.phone)
            if($client.listTo.auto) $reactions.answer("- автомобиль " + $client.listTo.auto)
        a: Наш сотрудник свяжется с вами и уточнит время.
        
    state: answer_signToClarification
        a: Для оформления заявки, уточните следующие данные:
        script:
            if(!$client.listTo.fio) $reactions.answer("- ваше ФИО")
            if(!$client.listTo.phone) $reactions.answer("- телефон")
            if(!$client.listTo.auto) $reactions.answer("- марка автомобиля")
        go: /Request/ask_signUpTo