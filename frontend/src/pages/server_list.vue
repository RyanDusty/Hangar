<script setup lang="ts">

const props = defineProps<{
    serverName?: string;
    serverInformation?: string;
    serverBanner?: MediaImage;
    serverIp?: string;
}>();


</script>
<!-- Search Bar and Info Text -->
<slot name="serverList">
  <template #Announcement>
    <slot name="serverListText">
      <div class="flex center flex-row-reverse mt-5 mb-2">
        <h1 class="text-4xl font-bold uppercase text-center mt-4 flex flex-col w-full">ProjectKorra Server List</h1>
      </div>
        <div class="text-1xl text-center mb-2 mt-1">
            Here you can find a list of Minecraft Servers which utilise ProjectKorra as one of their core plugins.
        </div>
     </slot>    

      <!--Server List-->
        <div class="p-5"></div>
          <hr class="divider opacity-30"/>
            <div class="flex w-100% mb-5">
              <div class="server-list">
                <!-- Server Filters -->
                <div class="flex-col-right">
                <!-- Servers -->
                <div class="servers"> 
                </hr>
                    <hr class="divider opacity-30"/>
                </hr>
                    <hr class="divider opacity-30"/>
                </hr>
                    <hr class="divider opacity-30"/>
                </hr>
                    <hr class="divider opacity-30"/>
                </hr>
                    <hr class="divider opacity-30"/>
                </hr>
          </div>
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
  .servers {
    height: 250px;
    width: 1250px;
    background: #201C1D;
    margin-right: 5;
    margin-left: 5;
  }
  .flex-col-right {
    display: flex;
    flex-direction: column;
    align-items: flex-end; /* Align children to the right */
    margin-left: auto; /* Push container to the right edge */
  }


</style>
