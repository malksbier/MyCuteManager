<template>
    <div class="topicListItem row justify-content-md-left">
        <div class="col-3">
           
            <div class="row">
                <!-- <p> {{ topic.name }} </p> -->
            
                <input type="text" class="form-control col" v-bind:placeholder="topic.givenName?topic.givenName:topic.name" aria-label="Username" aria-describedby="basic-addon1">

                <div class="col" v-if="topic.children.length !=0">
                    <button type="button" class="btn" @click="template.showChildren = !template.showChildren">
                        <i v-if="!template.showChildren" class="fa-solid fa-caret-up"></i>
                        <i v-if="template.showChildren" class="fa-solid fa-caret-down"></i>
                    </button>
                </div>
            </div>
            
        </div> 
        
        
        <div class="col-7" v-if="topic.info == 'relais'">
            <div class="btn-group" role="group" aria-label="Basic example">
                <button type="button" @click="onPressed()" class="btn btn-outline-primary">An</button>
                <button type="button" @click="offPressed()" class="btn btn-outline-primary">Aus</button>
            </div>
        </div>


        <div v-if="template.showChildren">
            <div class="topicListItemChildren"  v-for="t in topic.children" :key="t.id">
                <TopicListItem v-if="topic.children" v-bind:topic="t"></TopicListItem>
            </div> 
        </div>
         
    </div>
</template>
  
<script>



export default {
    name: "TopicListItem",
    props: [
        'topic',
        'depth'
    ],
    methods: {
        onPressed() {
            console.log("on" + this.topic)

            this.onOffReply.state = "on";
            this.axios.post(this.apiAdress + "/mqtt/setTopicState", this.onOffReply)
        },
        offPressed() {
            console.log("off" + this.topic)

            this.onOffReply.state = "off";
            this.axios.post(this.apiAdress + "/mqtt/setTopicState",this.onOffReply )
        },
    },
    data() {
      return {
        apiAdress: "http://192.168.2.108:8081",
        onOffReply: {
            id: this.topic.id,
            state: null,
        },
        template: {
            showChildren: true,
        }
      }
    },
    mounted(){
        //console.log("test " + this.topic)
        //console.log(this.marginLeft())
    }
  }
  </script>
  