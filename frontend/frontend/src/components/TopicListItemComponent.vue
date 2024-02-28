<template>
    <div class="topicListItem row justify-content-md-left">
        <!-- OWN Topic stuff -->
        <div class="col-md-auto" style="width: 100%;">
            <div class="row">  
                <div class="col  input-topic-name-width" >
                    <input class="form-control p-topic-name" v-model="template.newName" @keyup.enter="nameEdited()" v-bind:placeholder="topic.givenName?topic.givenName:topic.name" type="text" aria-label="Name" aria-describedby="basic-addon1">
                </div>
                
                <div class="col" v-if="topic.children.length !=0">
                    <button type="button" class="btn" @click="template.showChildren = !template.showChildren">
                        <i v-if="!template.showChildren" class="fa-solid fa-caret-up"></i>
                        <i v-if="template.showChildren" class="fa-solid fa-caret-down"></i>
                    </button>
                </div>
                <div class="col-6" v-if="topic.info == 'relais'">
                    <div class="btn-group" role="group" aria-label="Basic example">
                        <button type="button" @click="onPressed()" class="btn btn-outline-primary">An</button>
                        <button type="button" @click="offPressed()" class="btn btn-outline-primary">Aus</button>
                    </div>
                </div>
            </div>
            
        </div> 
        
        
        <!-- CHILDERN -->

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
        nameEdited() {
            if(this.newName != "") {
                console.log("new Name" + this.topic.name + " -> " + this.template.newName);
                this.newNameReply.newName = this.template.newName,
                this.axios.post(this.apiAdress + "/mqtt/setGivenName",this.newNameReply )
            }
            

            //this.onOffReply.state = "off";
            //this.axios.post(this.apiAdress + "/mqtt/setTopicState",this.onOffReply )
        },
    },
    data() {
      return {
        apiAdress: "http://192.168.2.108:8081",
        onOffReply: {
            id: this.topic.id,
            state: null,
        },
        newNameReply: {
            id: this.topic.id,
            newName: "",
        },
        template: {
            showChildren: true,
            newName: "",
        }
      }
    },
    mounted(){
        //console.log("test " + this.topic)
        //console.log(this.marginLeft())
    }
  }
  </script>
  