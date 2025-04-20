<script setup lang="ts">

const serverList = defineProps<{
    serverName?: string;
    serverInformation?: string;
    serverBanner?: MediaImage;
    serverIp?: string;
}>();


</script>

<template>
    <slot name="serverList">
        <div class="flex center flex-row-reverse mt-5 mb-2">
            <h1 class="text-4xl font-bold uppercase text-center mt-4 flex flex-col w-full">ProjectKorra Server List</h1>
        </div>
        <div class="text-1xl text-center mb-2 mt-1">
            Here you can find a list of Minecraft Servers which utilise ProjectKorra as one of their core plugins.
        </div>      
        <div class="p-5"></div>
          <hr class="divider opacity-30"/>
            <div class="flex w-100% mb-5">
              <div class="server-list">
                <div class="server-one"> 
                  </div>
                    <hr class="divider opacity-30"/>
                <div class="server-two">
                  </div>
                    <hr class="divider opacity-30"/>
                <div class="server-three">
                  </div>
                    <hr class="divider opacity-30"/>
                <div class="server-four">
                  </div>
                    <hr class="divider opacity-30"/>
                <div class="server-five">
                  </div>
                    <hr class="divider opacity-30"/>
            </div>
          </div>
    </slot>
</template>

<script setup>
</script>
<style lang="css" scoped>

  .server-list {
    height: 1250px;
    width: 1250px;
    background: #201C1C;
    margin-right: 5;
    margin-left: 5;
    
  }
  .server-one {
    height: 250px;
    width: 1250px;
    background: #201C1D;
    margin-right: 5;
    margin-left: 5;
    

  }
  .server-two {
    height: 250px;
    width: 1250px;
    background: #201C1C;
    margin-right: 5;
    margin-left: 5;
  }
  .server-three {
    height: 250px;
    width: 1250px;
    background: #201C1C;
    margin-right: 5;
    margin-left: 5;
  }
  .server-four {
    height: 250px;
    width: 1250px;
    background: #201C1C;
    margin-right: 5;
    margin-left: 5;
  }
  .server-five {
    height: 250px;
    width: 1250px;
    background: #201C1C;
    margin-right: 5;
    margin-left: 5;
  }

</style>