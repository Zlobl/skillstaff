
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
        q!: * {(ты/вы) * $who} *   
        go!: /Response/answer_whoAreYouName


        state:  ask_userName
            q: $fio
            script: 
                if ($parseTree["_fio"] && $parseTree["_fio"]["name"])  $client.fio =  $parseTree["_fio"]["name"];

            go!: /Response/answer_userName

    
    state:  ask_howAreYou
        q!: * {$how * (дела/настроение/ты там/пожев*/пожив*)} *
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

    state: ask_thanks
        q!: $thanks
        go!: /Response/answer_thanks

    state: NoMatch
        event!: noMatch
        script: $temp.response = toPrettyString($parseTree);
        a: Я не понял. Вы сказали: {{$temp.response}}

            