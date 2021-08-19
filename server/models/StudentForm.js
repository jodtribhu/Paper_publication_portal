const crypto=require('crypto');
const mongoose = require("mongoose");
mongoose.connect("mongodb://localhost:27017/Student_PublicationDB", { useNewUrlParser: true });
const StudentSchema=new mongoose.Schema({
    studentRollNo:{
        type:String,
        unique:[true,"Account is already present"],
        required:[true,"Email has not been entered"]
    },
    student_token:{
        type:String,
        required:[true,"Token has not been entered"]
    },
    created_at:{
        type:Date
    },
})
module.exports=mongoose.model("Student",StudentSchema);
