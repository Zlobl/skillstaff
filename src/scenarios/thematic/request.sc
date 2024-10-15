theme: /Request

    state: ask_priceTO
        q!: сколько стоит техобслуживание после первого года / а дорогое выйдет тео?
        go!:  /Response/answer_priceTO

    state: ask_scheduleTO
        q!: нужно ли ТО если машине год а пробег всего 3000 / когда делать ТО / когда ехать на то
        go!:  /Response/answer_scheduleTO
        
    state: ask_claimTO
        q!: почините то что сломали / мне повредили задний бампер когда делал у вас ТО на прошлой неделе, требую починить / если откажетесь чинить то я обращусь в роспотребнадзор / в вашем сервисе отказались менять фильтры не смотря на то что в машине странный запах
        go!:  /Response/answer_claimTO
 
    state: ask_whatTO
        q!: зачем нужно ТО
        go!: /Response/answer_whatTO

    state: ask_technicalProblemTO
        q!: купил машину у вас недавно и она почему то стала гудеть на 3000
        go!: /Response/answer_technicalProblemTO
        
        state: ask_technicalProblemTOYes
            q!: да
            go!: /Response/ask_signUpTo
        
        state: ask_technicalProblemTONo
            q!: нет
            go!: /Response/answer_technicalProblemTONo
        
    state: ask_discountTO
        q!: на ТО есть скидки?
        go!: /Response/answer_discountTO        
        
    state: ask_whatTimeTO
        q!: сколько по времени занимает ТО
        go!: /Response/answer_TimeTO    
        
    state: ask_whatFillingTO
        q!: в плановое ТО что входит
        go!: /Response/answer_whatFillingTO
        
        
        
        
        
        
        
        
        
