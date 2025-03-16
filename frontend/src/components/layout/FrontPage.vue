<template>
    <div class="front-page">
      <!-- Hero Section -->
      <div class="hero">
        <video class="hero-video" autoplay muted loop>
          <source src="@/assets/hero.webm" type="video/webm" />
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
        <div class="flex center mt-10 mb-10">
          <img src="@/assets/image1.png" alt="Image 1" class="image w-45% h-auto ml-6 mr-6" />
          <div class="text w-full ml-6 mr-6">
            <h2 class="text-3xl font-bold w-full">Custom Abilities</h2>
            <p class="text mt-4">Create and customize your own bending abilities to enhance your Minecraft experience.</p>
          </div>
        </div>
        <hr class="divider opacity-30" />
  
        <!-- Second Image-Text Pair -->
        <div class="flex center flex-row-reverse mt-10 mb-10">
        <img src="@/assets/image2.png" alt="Image 2" class="image w-45% h-auto ml-6 mr-6" />
          <div class="text w-full ml-6 mr-6">
            <h2 class="text-3xl font-bold w-full">Community Driven</h2>
            <p class="text mt-4">Join a vibrant community of benders and share your creations with others.</p>
          </div>
          
        </div>
        <hr class="divider opacity-30" />
  
        <!-- Third Image-Text Pair -->
        <div class="flex center mt-10 mb-10">
          <img src="@/assets/image3.png" alt="Image 3" class="image w-45% h-auto ml-6 mr-6" />
          <div class="text w-full ml-6 mr-6">
            <h2 class="text-3xl font-bold w-full">Endless Possibilities</h2>
            <p class="text mt-4">Explore a world of endless possibilities with ProjectKorra's extensive features.</p>
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