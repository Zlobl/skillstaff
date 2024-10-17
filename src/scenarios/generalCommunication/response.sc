theme: /Response
    

    state: answer_greeting
        a: Здравствуйте!


    state: answer_howAreYou
        random: 
            a: Отлично! А у вас?
            a: Хорошо, а вы как?
        go: /Request/ask_howAreYou


    state:  answer_howAreYou_good
        a: Я рад. Теперь давайте поговорим про автомобили.

    state:  answer_howAreYou_bad
        a: Жаль. Возможно, я смогу помочь. Задайте мне любой вопрос про наш автосервис.

    state: answer_whoAreYouName
        a: Меня зовут Вася.
        a: А вас?
        go: /Request/ask_whoAreYouName

    state: answer_userName
        a: Приятно познакомиться, {{$client.fio}}! 
        

    state: answer_bye
        a: Пока пока!
        
    state: answer_thanks
        a: Рад был помочь.