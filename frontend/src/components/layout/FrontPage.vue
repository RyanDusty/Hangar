<template>
    <div class="front-page">
      <!-- Hero Section -->
      <div class="hero">
        <video class="hero-video" autoplay muted loop>
          <source src="~/assets/hero.webm" type="video/webm" />
          Your browser does not support the video tag.
        </video>
        <div class="hero-overlay">
          <h1 class="hero-title">Welcome to ProjectKorra</h1>
          <p class="hero-subtitle">Empowering Bending Abilities in Minecraft</p>
        </div>
      </div>
  
      <!-- Content Section -->
      <div class="content">
        <!-- First Image-Text Pair -->
        <div class="flex center mt-25 mb-25">
          <div class="w-45% h-auto ml-6 mr-6 center">
            <img src="~/assets/img/aang.png" alt="Image 1" class="image w-350px h-350px center"  />
          </div>
          <div class="text w-full ml-6 mr-6">
            <h2 class="text-5xl font-bold w-full">Choose Your Element</h2>
            <p class="text text-2xl mt-8">Choose between Fire, Water, Earth, Air and Chi! Each element has unique facets and abilities that makes them unique, while remaining balanced so no element is stronger than another.</p>
          </div>
        </div>
        <hr class="divider opacity-30" />
  
        <!-- Second Image-Text Pair -->
        <div class="flex center flex-row-reverse mt-25 mb-25">
          <div class="w-45% h-auto ml-6 mr-6 center">
            <img src="~/assets/img/katara.png" alt="Image 2" class="image  h-auto w-350px center" />
          </div>
          <div class="text w-full ml-6 mr-6">
            <h2 class="text-5xl font-bold w-full">Master Your Bending</h2>
            <p class="text text-2xl mt-8">Learn to master your bending with the vast array of bending abilities! Learn to use them effectively in combat, combine your abilities to produce combos, and become the master of your element!</p>
          </div>
          
        </div>
        <hr class="divider opacity-30" />
  
        <!-- Third Image-Text Pair -->
        <div class="flex center mt-25 mb-25">
          <div class="w-45% h-auto ml-6 mr-6">
            <img src="~/assets/img/sokka.png" alt="Image 2" class="image w-auto h-350px center" />
          </div>
          <div class="text w-full ml-6 mr-6">
            <h2 class="text-5xl font-bold w-full">Your Server, Your Way</h2>
            <p class="text text-2xl mt-8">With hundreds of configuration options, customize your bending server however you like! Install community made abilities, create an Avatar cycle, make bending abilities unlockable - ProjectKorra can be configured to whatever you need!</p>
          </div>
        </div>
      </div>
    </div>
  </template>
  
  <script setup>
  </script>
  
  <style scoped>
  .front-page {
    display: flex;
    flex-direction: column;
    align-items: center;
    font-family: "Quicksand";
  }
  
  .hero {
    position: relative;
    width: 100%;
    height: 60vh;
    overflow: hidden;
  }
  
  .hero-video {
    width: 100%;
    height: 100%;
    object-fit: cover;
  }
  
  .hero-overlay {
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    background: rgba(0, 0, 0, 0.5);
    color: currentColor;
    text-align: center;
  }
  
  .hero-title {
    font-size: 3rem;
    margin: 0;
  }
  
  .hero-subtitle {
    font-size: 1.5rem;
    margin: 0;
  }

  .image {
    margin-left: auto;
    margin-right: auto;
    align-items: center;
    justify-content: center;
  }

  .center {
    margin-left: auto;
    margin-right: auto;
    align-items: center;
    justify-content: center;
    vertical-align: middle;
  }
  
  /** .image {
    width: 50%;
    height: auto;
    border-radius: 8px;
  }*/
  
  @media (max-width: 768px) {
    .hero-title {
      font-size: 2rem;
    }
  
    .hero-subtitle {
      font-size: 1rem;
    }
  
    .image-text-pair {
      flex-direction: column;
    }
  
    .image-text-pair.reverse {
      flex-direction: column;
    }
  
    .image {
      width: 100%;
      margin-bottom: 1rem;
    }
  
    .text {
      width: 100%;
    }
  
    .divider {
      width: 80%;
    }
  }
  </style>