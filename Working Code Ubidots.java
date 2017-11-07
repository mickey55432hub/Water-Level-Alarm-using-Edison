var sensor = usonic.sensor(18, 17, 1000);
setTimeout(function() {
    console.log('Distance: ' + sensor().toFixed(2) + ' cm');
}, 60);


var Sonar = require('raspi-sonar').Sonar;
var sonarPin1 = new Sonar(29);
sonarPin1.read(function(duration) {
  var distance = 343.0 * duration / 1000000 * .5;
  console.log('duration: ' + duration + ' distance: ' + distance + 'm');
});


var sensor = require('jsupm_grove');//
var send = new sensor.GroveButton(2);
send.read(function(duration) {
  var distance = 343.0 * duration / 1000000 * .5;
  console.log('duration: ' + duration + ' distance: ' + distance + 'm');
});



var distance = sensor();
var statistics = require('math-statistics');
var usonic = require('r-pi-usonic');
var init = function(config) {
    var sensor = usonic.sensor(config.echoPin, config.triggerPin, config.timeout);
    //console.log(config);
    var distances;
    (function measure() {
        if (!distances || distances.length === config.rate) {
            if (distances) {
                print(distances);
            }
 
            distances = [];
        }
 
        setTimeout(function() {
            distances.push(sensor());
 
            measure();
        }, config.delay);
    }());
};
var print = function(distances) {
    var distance = statistics.median(distances);
 
    process.stdout.clearLine();
    process.stdout.cursorTo(0);
 
    if (distance < 0) {
        process.stdout.write('Error: Measurement timeout.\n');
    } else {
        process.stdout.write('Distance: ' + distance.toFixed(2) + ' cm');
    }
};
init({
    echoPin: 18, //Echo pin
    triggerPin: 17, //Trigger pin
    timeout: 1000, //Measurement timeout in µs
    delay: 60, //Measurement delay in ms
    rate: 5 //Measurements per sample
});


























setInterval(function()
 {
 if (send.value()<0.500)
 {
 BlinkLED();
 melody();
 v.saveValue(1);
 console.log("Water level high");
}
 else
 console.log("water level low");
 v.saveValue(0);
 }, 1000);
// Print message when exiting
 process.on('SIGINT', function()
 {
 console.log("Exiting...");
 process.exit(0);
 });









 var ubidots = require('ubidots');
var client = ubidots.createClient('YOUR-API-KEY');
client.auth(function () {
  this.getDatasources(function (err, data) {
    console.log(data.results);
  });
  var ds = this.getDatasource('xxxxxxxx');
  ds.getVariables(function (err, data) {
    console.log(data.results);
  });
  ds.getDetails(function (err, details) {
   console.log(details);
 });
  var v = this.getVariable('xxxxxxx');
  v.getDetails(function (err, details) {
    console.log(details);
  });
  v.getValues(function (err, data) {
    console.log(data.results);
  });
  
