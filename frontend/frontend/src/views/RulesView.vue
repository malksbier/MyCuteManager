<template>
    <div>
        <h5>Rules</h5>
        <RulesAdd :topics="topics" :rules="rules" />
    </div>
  </template>
  
  <script>
  
    import RulesAdd from '../components/RulesAddComponent.vue'
  
    export default {
      components: {
        RulesAdd
      },
      data() {
        return {
            rules: null,
            topics: null,
        } 
      },
      mounted() {
        // get Topics
        this.axios
            .get('http://192.168.2.108:8081/mqtt/getAllTopics')
            .then(response => (this.topics = response.data))
            .catch(
                err => {
                    console.log(err)
                }
            )
            .finally(),
        // get rules
        this.axios
          .get('http://192.168.2.108:8081/mqtt/getAllRules')
          .then(response => (this.rules = response.data))
          .catch(
            err => {
              console.log(err)
            }
          )
          .finally()
          
      },
    }
  </script>