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



 
    //CODE FOR sending sms using twillio
    var twilio = require('twilio');
// Create a new REST API client to make authenticated requests against the
// twilio back end
var TWILIO_ACCOUNT_SID = '' ;
var TWILIO_AUTH_TOKEN = '';
var OUTGOING_NUMBER = '';
var TWILIO_NUMBER = '';
var client = new twilio.RestClient(TWILIO_ACCOUNT_SID, TWILIO_AUTH_TOKEN);
// Pass in parameters to the REST API using an object literal notation. The
// REST client will handle authentication and response serialzation for you.
client.sms.messages.create({
    to:OUTGOING_NUMBER,
    from:TWILIO_NUMBER,
    body:'Hi, sending from my Edison'
}, function(error, message) {
    // The HTTP request to Twilio will run asynchronously. This callback
    // function will be called when a response is received from Twilio
    // The "error" variable will contain error information, if any.
    // If the request was successful, this value will be "falsy"
    if (!error) {
        // The second argument to the callback will contain the information
        // sent back by Twilio for the request. In this case, it is the
        // information about the text messsage you just sent:
        console.log('Success! The SID for this SMS message is:');
        console.log(message.sid);
        console.log('Message sent on:');
        console.log(message.dateCreated);
    } else {
        console.log('error: ' + error.message);
    }
});


setInterval(function()
 {
 if (send.value()<0.500)
 {
 BlinkLED();
var client = new twilio.RestClient(TWILIO_ACCOUNT_SID, TWILIO_AUTH_TOKEN);
// Pass in parameters to the REST API using an object literal notation. The
// REST client will handle authentication and response serialzation for you.
client.sms.messages.create({
    to:OUTGOING_NUMBER,
    from:TWILIO_NUMBER,
    body:'Hi, Water level high'
}, function(error, message) {
    // The HTTP request to Twilio will run asynchronously. This callback
    // function will be called when a response is received from Twilio
    // The "error" variable will contain error information, if any.
    // If the request was successful, this value will be "falsy"
    if (!error) {
        // The second argument to the callback will contain the information
        // sent back by Twilio for the request. In this case, it is the
        // information about the text messsage you just sent:
        console.log('Success! The SID for this SMS message is:');
        console.log(message.sid);
        console.log('Message sent on:');
        console.log(message.dateCreated);
    } else {
        console.log('error: ' + error.message);
    }
 console.log("Water level high");
}
 else
 console.log("water filling");
 }, 1000);
// Print message when exiting





 if (send.value()<0.500)
 {
 BlinkLED();
var client = new twilio.RestClient(TWILIO_ACCOUNT_SID, TWILIO_AUTH_TOKEN);
// Pass in parameters to the REST API using an object literal notation. The
// REST client will handle authentication and response serialzation for you.
client.sms.messages.create({
    to:OUTGOING_NUMBER,
    from:TWILIO_NUMBER,
    body:'Hi, Water level Going low, Please Start fill up'
}, function(error, message) {
    // The HTTP request to Twilio will run asynchronously. This callback
    // function will be called when a response is received from Twilio
    // The "error" variable will contain error information, if any.
    // If the request was successful, this value will be "falsy"
    if (!error) {
        // The second argument to the callback will contain the information
        // sent back by Twilio for the request. In this case, it is the
        // information about the text messsage you just sent:
        console.log('Success! The SID for this SMS message is:');
        console.log(message.sid);
        console.log('Message sent on:');
        console.log(message.dateCreated);
    } else {
        console.log('error: ' + error.message);
    }
 console.log("Water level low");
}
 else
 console.log("Start water filling");
 }, 1000);
// Print message when exiting

}


 process.on('SIGINT', function()
 {
 console.log("Exiting...");
 process.exit(0);
 });






