const mongoose = require("mongoose");
mongoose.connect("mongodb://localhost:27017/Student_PublicationDB", { useNewUrlParser: true });
const FacultyProfile=require('../models/FacultyProfile');
module.exports={
    fetchAllFacultyProfiles(req,res){
        FacultyProfile.find(function(err,allfacultyProfiles){
            console.log("ALLLL FACULTTTTTY PRRRRRRROFILES")
            console.log(allfacultyProfiles);
            res.send(allfacultyProfiles);
        })
    },
}