theme: /Response
    

    state: answer_greeting
        a: Здравствуйте!


    state: answer_howAreYou
        random: 
            a: Отлично! А у вас?
            a: Хорошо, а вы как?
        go: /Request/ask_howAreYou


    state:  answer_howAreYou_good
        a: Это отлично! Как я могу помочь?


    state:  answer_howAreYou_bad
        a: Ужас! Могу ли я чем-то помочь?

    state: answer_whoAreYouName
        a: Меня зовут Вася.
        a: А вас?
        go: /Request/ask_whoAreYouName

    state: answer_userName
        a: Приятно познакомиться! {{$client.fio}}
        

    state: answer_bye
        a: Пока пока!
        
    state: answer_thanks
        a: Рад был помочь.