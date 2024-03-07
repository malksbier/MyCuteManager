<template>
    <div class="rules-add">
        <div class="card">
            <div class="card-body">
                <h5 class="card-title">Change Rules</h5>
                <form>
                    <!-- TOPIC SELECT -->
                    <div class="row">
                        <div class="col">
                            <label for="topicSelect">Topic</label>
                            <select class="form-control" id="topicSelect" v-model="template.topicId">
                                <option v-for="topic in this.topics" :key="topic.id"  :value="topic.id"> {{ resolveTopicName(topic) }}</option>
                            </select>
                        </div>
                    </div>
                    <!-- RULES -->
                    <div v-if="template.topicId != ''" class="mt-1">
                        <!-- TIMER -->
                        <div class="card">
                            <div class="card-body">
                                <!-- Head -->
                                <div class="row">
                                    <div class="col-auto">
                                        <h6 class="card-title" style="margin: 0px; padding-top: 8px; ">Timer</h6>
                                    </div>
                                    <div class="col-2">
                                        <button type="button" class="btn" @click="template.showTimerCard = !template.showTimerCard">
                                            <i v-if="!template.showTimerCard" class="fa-solid fa-caret-up"></i>
                                            <i v-if="template.showTimerCard" class="fa-solid fa-caret-down"></i>
                                        </button>
                                    </div>
                                </div>
                                <!-- Existing -->
                                <label for="time-rules">existing rules:</label>
                                <div id="time-rules" v-for="r in rules" :key="r.id">
                                    <p>
                                        {{ r.name }}
                                    </p>
                                </div> 
                                
                                <!-- ADD -->
                                <div v-if="template.timer.showCard">
                                    <label for="time-input-group">new Time schedule</label>
                                    <div id="time-input-group" class="input-group">
                                        <span class="input-group-text">ON</span>
                                        <span class="input-group-text">From</span>
                                        <input type="time" class="form-control" value="10:00" v-model="template.timer.from"/>
                                        <span class="input-group-text">Until</span>
                                        <input type="time" class="form-control" value="20:00" v-model="template.timer.until"/>
                                        <button @click="sendNewRule()" class="btn btn-outline-success" type="button">send</button>
                                    </div>
                                    <div>

                                    </div>
                                    
                                </div>
                            
                            </div>
                        </div>
                    </div>
                    
                    <!--
                    <div class="row">
                        <div class="col-md-6">
                            <label for="inputName">Name</label>
                            <input type="name" v-model="template.newName" class="form-control" id="inputName" placeholder="eg. TimerOutsideLamp">
                        </div>
                        <div class="col-md-6">
                            <label for="selectRule">Type</label>
                            <select class="form-control" id="selectRule" v-model="template.typeOfNewRule">
                                <option value="timer">Timer</option>
                                <option value="other">other</option>
                                <option value="other">other</option>
                            </select>
                        </div>
                    </div>
                        <div class="row" v-if="template.newName != '' && template.typeOfNewRule == 'timer' ">
                        <div class="col-xs-4">
                            <label for="topicSelect">Topic</label>
                            <select class="form-control" id="topicSelect" v-model="template.topicId">
                                <option v-for="topic in this.topics" :key="topic.id"  :value="topic.id"> {{ resolveTopicName(topic) }}</option>
                            </select>
                        </div>
                        <div class="col-xs-8">
                            <label for="topicSelect">Time</label>
                            <div class="input-group">
                                <span class="input-group-text">ON</span>
                                <span class="input-group-text">From</span>
                                <input type="time" class="form-control" value="10:00" />
                                <span class="input-group-text">Until</span>
                                <input type="time" class="form-control" value="20:00" />
                            </div>
                        </div>
                    </div>
                    
                    <div class="row">
                        <button @click="sendNewRule()" style="width:40%;" class="btn btn-success btn-block mt-3 mx-auto"> Send </button>
                    </div>
                    -->
                </form>
            </div>
        </div>
        <!--
        <h6>new Rule</h6>

        <div class="input-group mb-3">
        <div class="input-group-prepend">
            <span class="input-group-text">Name</span>
        </div>
        <input type="text" class="form-control" v-model="template.newName">
        <div class="input-group-append">
            <span class="input-group-text">Function</span>
        </div>
            <select class="custom-select input-group-append">
                <option selected value="1">Timer</option>
                <option value="2">other</option>
                <option value="3">other</option>
            </select>
        </div>
        TIME EDITER
        <div class="input-group" style="padding-left: 5vw;">

            <select class="custom-select input-group-append">
                <option selected value="1">Timer</option>
                <option value="2">other</option>
                <option value="3">other</option>
            </select>

            <span class="input-group-text">From</span>
            <input type="time" class="form-control" value="10:05" />
            <span class="input-group-text">Until</span>
            <input type="time" class="form-control" value="10:05" />
        </div>
    -->
    </div>
</template>
  
<script>
  export default {
    name: "RulesAddComponent",
    props: [
        'topics',
        'rules'
    ],
    methods: {
        resolveTopicName(topic) {
            if(topic.givenName == "") {
                return topic.name
            } else {
                return topic.givenName + " - " + topic.name
            }
        },
        sendNewRule() {
            this.reply.newRule.name = "not given",
            this.reply.newRule.rule = "TIMER {" + this.template.topicId + "} " + this.template.timer.from + " - " + this.template.timer.until,
            console.log(this.reply.newRule)

            this.axios.post(this.apiAdress + "/mqtt/writeNewRule", this.reply.newRule)
        },
    },
    data() {
      return {
        apiAdress: "http://192.168.2.108:8081",
        reply: {
            newRule:{
                name: "",
                rule: "",
            },
        },
        template: {
            timer: {
                showCard: true,
                from: "10:00",
                until: "20:00",
            },
            
            typeOfNewRule: "",
            newName: "",
            topicId: "",
        }
      }
    }
  }
</script>
  