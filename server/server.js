
const express= require('express');
const bodyParser=require('body-parser');
const cors=require('cors');
const morgan=require('morgan');
const config=require('./config/config');
const passport = require('passport');

const app=express();
app.use(bodyParser.urlencoded({limit: '50mb',extended:false,parameterLimit: 1000000 }));
app.use(bodyParser.json({limit: '50mb'}));
app.use(cors());
app.use(morgan('dev'));
app.use(express.static('public'));
require('./routes')(app)


app.listen(config.port||8081,function(err)
{
    if(err)
    {
        console.log(err);
    }
    else{
        console.log('Server has started');
    }
});

