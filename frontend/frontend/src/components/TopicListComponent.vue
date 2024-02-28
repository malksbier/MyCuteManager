<template>
    <div id="TopicListComponent">
        
        <div v-if="!loaded">
            <p>lädt</p>
        </div>
        <div v-if="loaded">
            <div v-for="t in topics" :key="t.id">
                <TopicListItem v-bind:topic="t"></TopicListItem>
            </div>
        </div>
        

        
    </div>
</template>

<script>
import TopicListItem from './TopicListItemComponent.vue'


export default {
    components: {
        TopicListItem
    },
    data() {
        return {
            topics: null,
            loaded: false,
        }
    },
    mounted() {
        this.axios
            .get('http://192.168.2.108:8081/mqtt/getAllTopics')
            .then(response => (this.topics = response.data))
            .catch(
                err => {
                    console.log(err)
                }
            )
            .finally(
                ()=> this.loaded = true    
            )
        console.log(this.topics)
    },  
    created() {
        
  }
}
</script>