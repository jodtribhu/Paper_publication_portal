<template>
    <div >
    <h1>Student Publications</h1>
    <base-card >
      <input type="text" v-on:keyup.delete="filter_publications()" v-on:keyup.enter="filter_publications()"  class="searchbar" v-model="searchkey" placeholder="Search..">
   
      <table>
              <tr>
                  <th> Student Name</th>
                  <th class="title_size"> Publication Title</th>
                  <th class="m_size"> Team Size</th>
                  <th class="details_size"> Details</th>
              </tr>
        </table>
      <p v-for="publication in pending_publications" :key="publication.PF_ID">
        <faculty-item  @refreshthepublication="refresh()" :publication_record="publication" ></faculty-item> 
        
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
        pending_publications:[{}]
      };
    },
    created(){
        if(this.$store.getters.checkFaculty)
         {
               this.loadeachfaculty();
               this.loadthePendingFacultyPublications(); 
         }
         else{
              this.getEach= this.$store.getters.getLoggedInFaculty;
              this.pending_publications=this.$store.getters.getFacultyPendingPublication
         }
    },
    methods:{
         async loadthePendingFacultyPublications(){
            await this.$store.dispatch("loadfacultypublication");
            this.pending_publications=this.$store.getters.getFacultyPendingPublication
       
        },
        refresh(){
            this.loadthePendingFacultyPublications(); 
        },
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
.details_size{
  width:5%;
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