theme: /Request
    # сколько стоит техобслуживание после первого года / а дорогое выйдет тео?
    state: ask_priceTO
        # сколько стоит техобслуживание после первого года
        q!: {$howMuch * (стоит/стоят/$beFut3 стоить/платить/обойдет*) * $TO}
        go!:  /Response/answer_priceTO

    # нужно ли ТО если машине год а пробег всего 3000 / когда делать ТО / когда ехать на то
    state: ask_scheduleTO
        # когда ехать на ТО
        q!: * {$when * $goInf * (на $TO)} *
        go!:  /Response/answer_scheduleTO
        
    # почините то что сломали / мне повредили задний бампер когда делал у вас ТО на прошлой неделе, требую починить / если откажетесь чинить то я обращусь в роспотребнадзор / в вашем сервисе отказались менять фильтры не смотря на то что в машине странный запах
    state: ask_claimTO
        # почините то что сломали 
        q!: * {($repair/$repairImper) * ($what $brokePastPl3)} *
        go!:  /Response/answer_claimTO
 
    state: ask_whatTO
        # для чего нужно ТО
        q!: * {$whatFor * $need * $TO} *
        go!: /Response/answer_whatTO

    state: ask_technicalProblemTO
        # купил машину у вас недавно и она почему то стала гудеть на 3000
        q!: * {($car/она) * ($buzz/$brokePast)} *
        go!: /Response/answer_technicalProblemTO
        
        #TODO - не понятно зачем здесь да и нет. Кажется их нужно удалить. 
        state: ask_technicalProblemTOYes
            # да
            q!: $yes
            go!: /Response/ask_signUpTo
        
        state: ask_technicalProblemTONo
            # нет
            q!: $no
            go!: /Response/answer_technicalProblemTONo
        
    state: ask_discountTO
        # на TO есть скидки?
        q!: {$TO * ($havePresReflSg3/$beFut3) * $discount}
        go!: /Response/answer_discountTO        
        
    state: ask_whatTimeTO
        # сколько по времени занимает TO
        q!: * {($howMuch/как ($quickly/$longAdv)) * $goPresContSg3 * $TO} *
        go!: /Response/answer_whatTimeTO    
        
    state: ask_whatFillingTO
        # в плановое TO что входит
        q!: * {$TO * $what * $included} *
        go!: /Response/answer_whatFillingTO
        
        
        
        
        
        
        
        
        
