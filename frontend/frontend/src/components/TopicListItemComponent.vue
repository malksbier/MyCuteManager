<template>
    <div class="topicListItem row justify-content-md-left" style="margin-left: 20px">
        <div class="col-3">
            <!-- <p> {{ topic.name }} </p> -->
            <input type="text" class="form-control" v-bind:placeholder="topic.givenName?topic.givenName:topic.name" aria-label="Username" aria-describedby="basic-addon1">
        </div>
        
        
        <div class="col-7" v-if="topic.info == 'relais'">
            <div class="btn-group" role="group" aria-label="Basic example">
                <button type="button" @click="onPressed()" class="btn btn-outline-primary">An</button>
                <button type="button" @click="offPressed()" class="btn btn-outline-primary">Aus</button>
            </div>
        </div>



        <div class="topicListItemChildren" v-for="t in topic.children" :key="t.id">
            <TopicListItem v-if="topic.children" v-bind:topic="t"></TopicListItem>
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
            this.axios.post("http://localhost:8081/mqtt/setTopicState", this.onOffReply)
        },
        offPressed() {
            console.log("off" + this.topic)

            this.onOffReply.state = "off";
            this.axios.post("http://localhost:8081/mqtt/setTopicState",this.onOffReply )
        },
    },
    data() {
      return {
        onOffReply: {
            id: this.topic.id,
            state: null,
        }
      }
    },
    mounted(){
        //console.log("test " + this.topic)
        //console.log(this.marginLeft())
    }
  }
  </script>
  