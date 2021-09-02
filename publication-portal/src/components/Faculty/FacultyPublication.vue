<template>
    <div >
    <h1>Student Publications</h1>
    <base-card >
      <input type="text" v-on:keyup.delete="filter_publications()" v-on:keyup.enter="filter_publications()"  class="searchbar" v-model="searchkey" placeholder="Search..">
      <p>.</p>
      <table>
              <tr>
                  <th> Student Name</th>
                  <th> Student Roll Number</th>
                  <th class="title_size"> Publication Title</th>
                  <th class="m_size"> Team Size</th>
                  <th class="m_size"> Mark</th>
                  <th> Details</th>
              </tr>
        </table>
      <p v-for="publication in x" :key="publication._id">
        <faculty-item  :publication_record="publication" ></faculty-item> 
      </p>
    </base-card>
   
    </div>
</template>

<script>
import FacultyItem from './FacultyItem.vue';
export default {
    components: { FacultyItem },
    data(){
      return {
        searchkey:'',
        x:[],
        publications:[ {name:"Yadhu Nandan",rollNo:"CB.EN.U4CSE18368",email:"cb.en.u4cse18368@cb.students.amrita.edu",ptitle:"Research Paper Classification",
start:"01-01-2021",end:"10-08-2021",journal:"true",conference:"false",jname:"Scientific Reports",cname:null,teamsize:4,mark:8,},
      {name:"Jodiss Tribhu",
      rollNo:"CB.EN.U4CSE18327",
      email:"cb.en.u4cse18327@cb.students.amrita.edu",
      ptitle:"Alzheimer's Detection",
      start:"05-09-2020",
      end:"15-11-2020",
      journal:"true",
      conference:"false",
      jname:"Science Advances",
      cname:null,
      teamsize:4,
      mark:8},
      {name:"Ashwin K",
        rollNo:"CB.EN.U4CSE18307",
        email:"cb.en.u4cse18307@cb.students.amrita.edu",
        ptitle:"Smart Home System",
        start:"07-10-2020",
        end:"30-12-2020",
        journal:"true",
        conference:"false",
        jname:"Science",
        cname:null,
        teamsize:1,
        mark:6},
        {name:"Sreekar K",
          rollNo:"CB.EN.U4CSE18330",
          email:"cb.en.u4cse18330@cb.students.amrita.edu",
          ptitle:"Glaucoma Detection",
          start:"07-10-2020",
          end:"30-12-2020",
          journal:"true",
          conference:"false",
          jname:"Science Advances",
          cname:null,
          teamsize:3,
          mark:7},
          {name:"Abhilash Parayil",
            rollNo:"CB.EN.U4CSE18301",
            email:"cb.en.u4cse18301@cb.students.amrita.edu",
            ptitle:"Spam Mail Classification",
            start:"17-09-2020",
            end:"31-12-2020",
            journal:"false",
            conference:"true",
            jname:null,
            cname:"Cyber Summit",
            teamsize:1,
            mark:8},
]
      };
    },
    created(){
      this.x=this.publications;
    },
    methods:{
        
        filter_publications(){
            this.x=this.publications.filter((publication) => {
              if (publication.name.toLowerCase().includes(this.searchkey.toLowerCase())) {
                  return true;
               }
            });
            console.log("INSIDE HEREE");
        }
    },

    
}
</script>

<style scoped>
.m_size{
  width:10%;
}
.title_size{
    width:40%;
}
th{
  border: 1px solid black;
  padding:0.6rem;
  background-color:rgb(120, 155, 161);
}
 h4{
  text-align:center;
  font-family: 'Montserrat', sans-serif;
  color: black;
}
.searchbar {
  border: 1px solid #ccc;
  float: right;
  padding: 6px;
  margin-top: 8px;
  margin-right: 16px;
  font-size: 17px;
 
}
table{
  width: 100%;
}
th{
    text-align:center;
    width:19%;
    font-family: 'Montserrat', sans-serif;
}


button {
  text-decoration: none;
  padding: 0.75rem 1.5rem;
  margin-top: 8px;
  font-family: 'Montserrat', sans-serif;
  background-color: #3a0061;
  border: 1px solid #3a0061;
  color: white;
  cursor: pointer;
  border-radius: 30px;
}

button:hover,
button:active {
  background-color: #270041;
  border-color: #270041;
}

.flat {
  background-color: transparent;
  color: #3a0061;
  border: none;
}

.outline {
  background-color: transparent;
  border-color: #270041;
  color: #270041;
}

.flat:hover,
.flat:active,
.outline:hover,
.outline:active {
  background-color: #edd2ff;
}
h1{
  text-align: center;
    font-family: 'Montserrat', sans-serif;
}
</style>