<template>
    <admin-card>
            <h1>Dashboard</h1>
            <div class="Numbers">
                <div class="rectangle1">
                    <div class="text">
                        <p class="remove_p1">{{adminFacultyLength}}</p>
                        <p class="remove_p2">Faculty</p>
                    </div>
                    <div class="symbol">
                        <i class=" each_symbol fas fa-chalkboard-teacher"></i>
                    </div>
                </div>
                <div class="rectangle2">
                    <div class="text">
                        <p class="remove_p1">{{adminStudentLength}}</p>
                        <p class="remove_p2">Students</p>
                    </div>
                    <div class="symbol">
                        <i class=" each_symbol fas fa-user-graduate"></i>
                    </div>
                </div>
                <div class="rectangle3">
                    <div class="text">
                        <p class="remove_p1">{{acceptedCount}}</p>
                        <p class="remove_p2">Accepted</p>
                    </div>
                    <div class="symbol">
                        <i class=" each_symbol far fa-check-circle"></i>
                    </div>
                </div>
                <div class="rectangle4">
                    <div class="text">
                        <p class="remove_p1">{{rejectedCount}}</p>
                        <p class="remove_p2">Rejected</p>
                    </div>
                    <div class="symbol">
                        <i class=" each_symbol far fa-times-circle"></i>
                    </div>
                </div>
            </div>
            <div class="graphs">
                <div class="graph_card">
                    <h2>Registered Users</h2>
                    <apexchart width="380" type="donut" :options="registeredchartOptions" :series="registeredseries"></apexchart>
                </div>
                <div class="graph_card">
                    <h2>Publications</h2>
                    <apexchart width="380" type="donut" :options="publicationchartOptions" :series="publicationseries"></apexchart>
                </div>
                 
            </div>


          

    </admin-card>
</template>

<script>
export default {
    components: {},
    data(){
        return{
            adminFacultyLength:0,
            adminStudentLength:0,
            acceptedCount:0,
            rejectedCount:0,
            registeredchartOptions: {
                            chart: {fontFamily: 'Montserrat, sans-serif',},
                            colors:['#13a608','#ff9a1f'],
                            stroke: {
                                    width:0
                                },
                            dataLabels: {
                                    style: {
                                        colors: ['#e6e6e6'] }
                                },
                            labels:['Faculty','Students']
                        },

            registeredseries: [], 

            publicationchartOptions: {
                            chart: {fontFamily: 'Montserrat, sans-serif',},
                            colors:['#106ead','#ad0958'],
                            stroke: {
                                    width:0
                                },
                            dataLabels: {
                                    style: {
                                        colors: ['#e6e6e6'] }
                                },
                            labels:['Accepted','Rejected']
                        },

            publicationseries: [], 
        }
    },
    created() {
        if(this.$store.getters.checkAdminFaculty==false || this.$store.getters.checkAdminStudent==false)
         {
             
            this.loadall();
         }
         else{
            var listArray = []
            this.adminFacultyLength=this.$store.getters.getAdminFacultyLength
            this.adminStudentLength=this.$store.getters.getAdminStudentLength
            listArray.push(this.$store.getters.getAdminFacultyLength)
            listArray.push(this.$store.getters.getAdminStudentLength)
            this.registeredseries=listArray;
         }
        if(this.$store.getters.getAcceptedcount==-1 || this.$store.getters.getRejectedcount==-1)
         {
            this.loadTotalPublications(); 
         }
         else{
            var listArray2 = []
            this.acceptedCount=this.$store.getters.getAcceptedcount
            this.rejectedCount=this.$store.getters.getRejectedcount
            listArray2.push(this.acceptedCount)
            listArray2.push(this.rejectedCount)
            this.publicationseries=listArray2
         }

    },
    methods:{
        async loadall(){
            try {
                console.log("inside loadall");
                await this.$store.dispatch("loadadminfacultypublication");
                await this.$store.dispatch("loadadminstudentpublication");
                var listArray = []
                this.adminFacultyLength=this.$store.getters.getAdminFacultyLength
                this.adminStudentLength=this.$store.getters.getAdminStudentLength
                listArray.push(this.$store.getters.getAdminFacultyLength)
                listArray.push(this.$store.getters.getAdminStudentLength)
                this.registeredseries=listArray;
            
            } catch (error) {
                console.log(error);
              
            }
        },
        async loadTotalPublications(){
            try {
                await this.$store.dispatch("loadTotalPublications");
                var listArray2 = []
                this.acceptedCount=this.$store.getters.getAcceptedcount
                this.rejectedCount=this.$store.getters.getRejectedcount
                listArray2.push(this.acceptedCount)
                listArray2.push(this.rejectedCount)
                this.publicationseries=listArray2
            } catch (error) {
                console.log(error);
            } 
        }
    }
    
}
</script>

<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+Mono:wght@200&display=swap');
.Numbers{
    display: flex;
    justify-content: space-around;
}
.graph_card{
  width:38%;
  position: relative;
  border-radius: 12px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.26);
  border:0.32rem solid rgb(94, 97, 94);
  padding: 1rem;
  margin: 2rem auto;
  background-color: #e9e6e6;
}
.graphs{
    display: flex;
}
@import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@500&display=swap');
.rectangle1 {
  border-radius:0.4rem;
  height: 7.2rem;
  width: 13.2rem;
  display: flex;
  background-color: #2dad10;

  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.26);
}
.rectangle2 {
  border-radius:0.4rem;
  height: 7.2rem;
  width: 13.2rem;
  display: flex;
  background-color: #db9316;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.26);
}
.text{
    display: flex;
    font-family: 'Montserrat', sans-serif;
    flex-direction: column;
    justify-content:center;
        min-width:50%;
}
.remove_p1{
    margin:0;
    text-align:center;
     font-size: 1.8rem;
     font-weight:bold;
}
.remove_p2{
    margin:0;
    text-align:center;
     font-size: 1.2rem;
}
.symbol{
    min-width:50%;
    min-height:100%;
   
    display: flex;
    justify-content:center;
    align-items:center;

}
.each_symbol{
    font-size:4rem;
    color:rgb(207, 204, 204);
}
.rectangle3 {
  border-radius:0.4rem;
  height: 7.2rem;
  width: 13.2rem;
  display: flex;
  background-color: #106ead;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.26);
}
.rectangle4 {
  border-radius:0.4rem;
  height: 7.2rem;
  width: 13.2rem;
  display: flex;
  background-color: #ad0958;
 box-shadow: 0 4px 8px rgba(0, 0, 0, 0.26);
}

.faculty_Card {
  border-radius: 12px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.26);
  padding: 1rem;
  margin:auto;
  background-color: #f6f6f6;
  width: 70%;
}
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+Mono&display=swap');
h1{
    font-family: 'Noto Sans Mono', monospace;
    text-align: center;
    margin-top:0;
    padding:2rem;
    font-weight: 500;
    font-size:2.4rem;
}
h2{
    font-family: 'Montserrat', sans-serif;
    text-align: center;
    margin-top:0;
    padding:2rem;
}
button{
    border-radius: 10px 10px;
    height: 3rem;
    color: rgb(212, 205, 205);
    padding-left:1.5rem;
    padding-right:1.5rem;
    font-family: 'Montserrat', sans-serif;
    font-weight: bold;
    font-size: 1rem;
   
    background-color:rgb(31, 29, 119);
    border-style:0 solid;
}


</style>