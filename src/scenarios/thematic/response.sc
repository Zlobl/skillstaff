theme: /Response




    state: answer_priceTO
        a: Стоимость обслуживания можно рассчитать [тут](http://someautodealer/techservice#calculate)


    state: answer_scheduleTO
        a: График технического обслуживания можно узнать [тут](http://someautodealer/techservice).

    state: answer_claimTO
        a: [Позвоните моим коллегам](http://someautodealer/contacts), чтобы разобраться в ситуации.

    state: answer_whatTO
        a: Техническое обслуживание нужно, чтобы предотвратить вероятность случайных поломок, а также произвести регулировку всех основных узлов и агрегатов, чтобы максимально снизить расход топлива и смазочных материалов.
        go!: /Request/ask_technicalProblemTO

    state: answer_technicalProblemTO
        a: Давайте запишу вас на техническое обслуживание?
        go: /Request/ask_technicalProblemTO
        
    state: answer_discountTO
        a: Акции на техническое обслуживание представлены [тут](http://someautodealer/techservice#actions)
        
    state: answer_whatTimeTO
        a: В среднем техническое обслуживание занимает 2 часа. Зависит от конкретного плана работ.
        
    state: answer_whatFillingTO
        a: План работ технического обслуживания можно узнать [тут](http://someautodealer/techservice).
        
    state: answer_technicalProblemTONo
        a: Если передумаете, дайте нам знать.
        
        
        
        
        
        
        