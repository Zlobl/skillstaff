
theme: /Request


    state: Start
        q!: $regex</start>
        a: Начнём.

    
    # Общекоммуникативные мини-сценарии.
    state: ask_greeting
        q!: $helloAll
        go!: /Response/answer_greeting

     # Общекоммуникативные мини-сценарии. как тебя зовут / ты кто
    state: ask_whoAreYouName
        q!: * {$how * $youAcc * $nameVPresPl3} *
        go!: /Response/answer_whoAreYouName


         # TODO:   есть сущность от джастов, нужно использвоть её
        state:  ask_userName
            q: имя сущности 
            go!: /Response/answer_howAreYou

    
    state:  ask_howAreYou
        q!: * {$how * (дела/настроение/ты там)} *
        go!: /Response/answer_howAreYou


        state: ask_howAreYou_good
            q: $comGood
            go!: /Response/answer_howAreYou_good


        state: ask_bad
            q: $comBad
            go!: /Response/answer_howAreYou_bad
        


    state: ask_bye
        q!: $comBye
        go!: /Response/answer_bye



    state: NoMatch
        event!: noMatch
        a: Я не понял. Вы сказали: {{$request.query}}

            