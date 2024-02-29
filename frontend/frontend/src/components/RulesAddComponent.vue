<template>
    <div class="rules-add">
        <div class="card">
            <div class="card-body">
                <h5 class="card-title">Add Rule</h5>
                <form>
                    <div class="row">
                        <div class="col-md-6">
                            <label for="inputName">Name</label>
                            <input type="name" v-model="template.newName" class="form-control" id="inputName" placeholder="eg. TimerOutsideLamp">
                        </div>
                        <div class="col-md-6">
                            <label for="selectRule">Type</label>
                            <select class="form-control" id="selectRule" v-model="template.typeOfNewRule">
                                <option value="timer">timer</option>
                                <option value="other">other</option>
                                <option value="other">other</option>
                            </select>
                        </div>
                    </div>
                        <div class="row" v-if="template.newName != '' && template.typeOfNewRule == 'timer' ">
                        <div class="col-xs-4">
                            <label for="topicSelect">Topic</label>
                            <select class="form-control" id="topicSelect" v-model="template.topicId">
                                <option v-for="topic in this.topics" :key="topic.id"  :value="topic.id"> {{ topic.name }}</option>
                            </select>
                        </div>
                        <div class="col-xs-8">
                            <label for="topicSelect">Time</label>
                            <div class="input-group">
                                <span class="input-group-text">From</span>
                                <input type="time" class="form-control" value="10:00" />
                                <span class="input-group-text">Until</span>
                                <input type="time" class="form-control" value="20:00" />
                            </div>
                        </div>
                    </div>
                    
                    <div class="row">
                        <button style="width:40%;" class="btn btn-success btn-block mt-3 mx-auto"> Send </button>
                    </div>
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
        'topics'
    ],
    methods: {
        onPressed() {

        },
    },
    data() {
      return {
        apiAdress: "http://192.168.2.108:8081",
        onOffReply: {
            id: 1,
            state: null,
        },
        newNameReply: {
            id: 1,
            newName: "",
        },
        template: {
            typeOfNewRule: "",
            newName: "",
            topicId: "",
        }
      }
    }
  }
</script>
  