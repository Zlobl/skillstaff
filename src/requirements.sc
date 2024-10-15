require: dicts/countryCodes.yaml
    var = countryCodes
    
require: common.js
    module = sys.zb-common
    
require: city/city.sc
    module = sys.zb-common

require: where/where.sc
    module = sys.zb-common
    

require: number/number.sc
    module = sys.zb-common

require: car/carBrand.sc
    module = sys.zb-common

require: dateTime/dateTime.js
    module = sys.zb-common
    
require: dateTime/dateTime.sc
  module = sys.zb-common

require: functions/integration.js
require: functions/functions.js
    
require: patterns.sc
require: scenarios/createTO/request.sc
require: scenarios/createTO/response.sc
require: scenarios/generalCommunication/request.sc
require: scenarios/generalCommunication/response.sc
require: scenarios/thematic/request.sc
require: scenarios/thematic/response.sc


