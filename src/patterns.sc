patterns:
    #A
    $again = (заново/снова/вновь/опять/в котор* раз/повторно/~второй ~раз)
    #B
    $buzz = (стала гудеть/гудит)
    $beFut3 = (будет/будут)
    $brokePast = (сломал*/поломал*/выломал*/погнул*/треснул*/лопнул*/повредил*/изуродовал*/разбил*/побил*/поцарапал*/вдавил*/прожгл*/испортил*/оторвал*/вырвал*/заклинил*)
    $brokePastPl3 = (сломали/поломали/выломали/погнули/треснули/лопнули/повредили/изуродовали/разбили/побили/поцарапали/вдавили/прожгли/испортили/оторвали/вырвали/заклинили)
    #C
    $car = (~машина/~автомобиль/автамобил*/$regexp<а\/?м>/машинк*/авто/тачк*/тачил*/тачак*/~карета/~корыто/~ведро/колымаг*/калымаг*)
    $comGood = (ура/урра/хорошо/хорош/Хлршшо/харашо/good/гуд/отлично/отличненько/otlihnno/otlihno/клево/клевенько/круто/крутотень/крутяк/класс/классно/классненько/клас/класно/класненько/замечательно/великолепно/прекрасно/здорово/здорого/ок/ok/0к/О к/o k/jr/Okey/окей/окэй/оке/окэ/о (кей/кэй)/норм/нормально/$super)
    $comBad = (плохо/ужасно/отстойно/говняно/отвратительно/херово/хреново/не оч/неоч/не очень/неочень)
    $comBye = ([ладно/все/давай/ну] (пока [пока]/пака [пака]/(до/да) (свидан*/[скорой] встречи/завтра/скорого [свидания])/досвидан*/досвидос/дозавтра/прощай/бай/бай бай/я (пошел/пошла/ушла/отошел/отошла/отойду/уйду/ушел/ухожу/пойду)/гудбай/чау/чао/poka/чмоки чмоки/пока-пока/пака-пака/покедова/покеда/покасики/п о к а/мне (пора/нужно) (идти/*спать/*учиться/*работать/уходить)/всего [$youDat] доброго/не поминай* лихом/адью/адье/хорошего дня/всего [вам] хорошего))
    #D
    $discount = (скидк*/скитк*/скидо*)
    $doVInfPerf = (сделать/зделать/сделаиь/зделаиь/сделоть/зделоть/сделоиь/зделоиь/заделать/заделаиь)
    $doVInfCont = (делать/делоть)
    $doVInf = ($doVInfCont/$doVInfPerf)
    #E
    #F
    #G                                
    $goPresContSg3 = (идет/проходит/длитс*/длитьс*/занимает)
    $goInf = (ехать/поехать/выехать/выезжать/заехать/проехать/съездить/сьездить/ездить/выезжать/отправитьс*/отправитс*/путешествовать/кататьс*/кататс*/скататьс*/скататс*/уехать/доехать/передвигатьс*/передвигатс*/добратьс*/добратс*/рвануть/пригнать)
    #H
    $how = (как/каким образом)
    $howMuch = (сколько/сколь/сколко/сколька/скока/сколка/скок/(много/многа) $li/как (много/многа))
    $havePresReflSg3 = (есть/имеетс*/имеетьс*/существует/имеет $li)
    $helloAll = ([еще раз/[и] $again/всем] (привет* [привет]/привеет/приивеет/приветик*/при вед/привед/п р и в е т/приве/прив/привитули/приветствую/здравствуй*/здравствуй те/здрас*/здравствуте/сдррасвуйте/здрас вуйте/здравствует е/здаров/здарова/здравия/здаровеньки/здоровеньки/дратути/high/ку/хэй/эй/хэй/хай/хаюшки/хэлло*/хело/хелло*/халоу/хэлоу/шалом/hello/hi/{(~добрый/добри) (~утро/утречк*/~день/ден/~вечер/вече/вечер*/вечерка/~ночь/[$youDat/всем] (~здоровье/здравия))}/~добрый [$youDat/всем] [~прекрасный] (~время/дня) суток/доброговремени суток/добрый/(салам/салаам/Salom/салом) [алейкум]/салют/слыш* [ты]) [еще раз]/добро ночи/добре утро/добрый ночки/добра день/драсти/хелоу)
    #I
    $included = (входит/включено)
    #J
    #K
    #L
    $longAdv = (долго/долга/долгл)
    $li = (ли/ль)
    #M
    #N
    $nameVPresPl3 = (завуд/завуи/завут/завутъ/звут/злвут/зоаут/зовкт/зовуд/зовуи/зовут/зовут то/зовутъ/зовуть/зовыт/зоувт/овут/хавут/ховут/зо вут/задут/щовут/щавут/изовут/заут/зовт/завот/зовус/зовцт/зоввут/зовуь/зоут/зовук/зовтуа/мзовут/зувут/величают/называют/кличат/кличут)
    $no = (нет/нету/неат/ниат/неа/ноуп/ноу/найн)
    $need = (нужно/нужен/нжен/нуден/нуен/нужн*/нужео/нуно/надо/нада/требуетс*/требуитс*/требоватьс*/требуютс*/потребуетс*/потребуитс*/потребоватьс*/потребуютс*/необходим*/ниобх*/понадобит*/понадобят*)
    #O
    #P
    $phone = $regexp<(8|\+?7)-?\(?9\d{2}\)?-?\d{3}-?\d{2}-?\d{2}>
    #Q
    $quickly = (быстро/скоро)
    #R
    $repair = (~ремонт/римонт*/починк*/пачинк*)
    $repairImper = (почини*/почени*/пачени*/отремонтируй*/отримонтируй*/чините/чените)
    #S
    $super = (супер/суперски/супир/супирски/super)
    #T
    $TO = (то/техосмотр*/обслуж*/тех осмотр*/техническ* осмотр*/~техобслуживание)
    #U
    #V
    #W
    $what = (что/че/чо/шо)
    $whatFor = (для чего/зачем)
    $when = (когда/(во/через) сколько/(как/насколько) $quickly/$quickly $li/(в течени*/втечени*/через/в) (~какой/~который) ~время/(в течени*/втечени*) скольк*)
    #X
    #Y
    $youAcc = (вас/тебя)
    $youDat = (вам/тебе)
    $yes = ({да [конечно]}/ага/ога/угу/так точно/конечно/естесственно/а как же)
    #Z

    #словари
    $GreaterZero = $regexp<[1-9]\d*> || converter = $converters.numberConverterDigit
    $customNumber = ( @duckling.number) 
    $customNumberZero = (нол*|нул*|zero|0):0 || converter = $converters.numberConverterValue
    $cityOrDate = {[* @duckling.date *][* $City *]}
    $day = (({[$customNumber | $GreaterZero] (*день|*дней*|*дня*|*сут*)})| $customNumber | $GreaterZero )
    $week = {[$customNumber | $GreaterZero] *недел* }  
    $month = {[$customNumber | $GreaterZero] *месяц* } 
    $year = {[$customNumber | $GreaterZero] (*год*|*лет*) } 
    $periodToDay = ({[* $day *] [* $month *] [* $week *] [* $year *]}) || converter = convertToDays
    $pastDate = (* @duckling.date *)
    $curentFutureDate = (* @duckling.date *)
    $oneWord = $regexp<\pL{1,}> 
    $name = ({* @mystem.persn * [@mystem.famn]} | ($oneWord $oneWord $oneWord))
    $rejection = { [* @неХочу *] [* @зачем *] [* @неЗнаю *] }
    $futureTime = {({*след* (* $day *|* $month *|* $week *|* $year *)})} || converter = convertToDays
    
    # $inTo = {[*прой*] [*запис*] [$TO]}
    # $inTo = {[* *пройти* *]  [* *запис* *] [$TO]}
    # $fio =  {[@pymorphy.surn] [@pymorphy.name] [@pymorphy.patr]} 
    # $signUpTo = {[$fio] [$CarBrand ] [$inTo]} || converter = test 
    




    $inTo = {(пройт*/запис*) * $TO}
    $fio =  {[@pymorphy.surn] [@pymorphy.name] [@pymorphy.patr]} 




    $signUp = ( 
        {$inTo [$fio] [$CarBrand]} |
        {[$inTo] $fio [$CarBrand]} |
        {[$inTo] [$fio] $CarBrand} |
        ) || converter = test

       