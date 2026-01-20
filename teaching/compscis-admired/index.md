---
layout: default
title: Document Archive
---

<div class="gallery-grid">
  <div class="document-item">
    <a href="assets/images/dwork-oct-2025.jpg" target="_blank" title="Click to view full size">
      <img src="assets/images/thumbs/dwork-oct-2025.jpg" alt="Cynthia Dwork description">
      <span class="view-label">Open Full Page</span>
    </a>
  </div>

  <div class="document-item">
    <a href="assets/images/bengio-jan2026.jpg" target="_blank" title="Click to view full size">
      <img src="assets/images/thumbs/bengio-jan2026.jpg" alt="Yoshua Bengio description">
      <span class="view-label">Open Full Page</span>
    </a>
  </div>
</div>

<style>
  /* Grid Layout */
  .gallery-grid {
    display: grid;
    grid-template-columns: repeat(auto-fill, minmax(200px, 1fr));
    gap: 25px;
    padding: 20px 0;
  }

  /* Container for each thumbnail */
  .document-item {
    background: white;
    border: 1px solid #e1e4e8;
    border-radius: 6px;
    padding: 10px;
    text-align: center;
    transition: box-shadow 0.2s ease-in-out;
  }

  .document-item:hover {
    box-shadow: 0 8px 20px rgba(0,0,0,0.12);
  }

  /* Force the thumbnail to look like a US Letter sheet */
  .document-item img {
    width: 100%;
    height: auto;
    aspect-ratio: 8.5 / 11; /* Maintains the US Letter shape */
    object-fit: cover;
    border: 1px solid #eee;
    margin-bottom: 10px;
  }

  /* Link styling */
  .document-item a {
    text-decoration: none;
    display: block;
  }

  .view-label {
    font-size: 14px;
    font-weight: bold;
    color: #159957; /* Matches Cayman green */
  }
</style>
