
theme: /Request


    state: Start
        q!: $regex</start>
        a: Начнём.

    
    # Общекоммуникативные мини-сценарии.
    state: ask_greeting
        q!: привет 
        go!: /Response/answer_greeting

     # Общекоммуникативные мини-сценарии. как тебя зовут / ты кто
    state: ask_whoAreYouName
        q!: как тебя зовут
        go!: /Response/answer_whoAreYouName


         # TODO:   есть сущность от джастов, нужно использвоть её
        state:  ask_userName
            q: имя сущности 
            go!: /Response/answer_howAreYou

    
    state:  ask_howAreYou
        q!: как дела
        go!: /Response/answer_howAreYou


        state: ask_howAreYou_good
            q:  $regexp_i<.*(хорош|норм|отли|харош).*>
            go!: /Response/answer_howAreYou_good


        state: ask_bad
            q: $regexp_i<.*(плох|не оч|неоч|хрен).*>
            go!: /Response/answer_howAreYou_bad
        


    state: ask_bye
        q!: пока
        go!: /Response/answer_bye



    state: NoMatch
        event!: noMatch
        a: Я не понял. Вы сказали: {{$request.query}}

            