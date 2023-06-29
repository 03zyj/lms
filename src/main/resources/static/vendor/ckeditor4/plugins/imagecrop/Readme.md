## ImageCrop

A CKEditor plugin to add simple crop for images.
Crop it using [cropper.js](https://fengyuanchen.github.io/cropperjs/) and save to server.

## Installation
1. Download the `imagecrop` plugin from repository
2. Place the `imagecrop` folder into the plugins folder of CKEditor ( *{Path to CKEDitor}/plugins/* )
3. Open the config.js file and add the following lines:

```
    CKEDITOR.editorConfig = function( config ) {
        config.extraPlugins = 'imagecrop';

        // Setup cropper options. (See cropper.js documentation https://github.com/fengyuanchen/cropperjs)
        config.cropperOption = {
            "aspectRatio": 16 / 9,
            "autoCropArea": 1,
            "background": false,
            "cropBoxResizable": true,
            "dragMode": "move"
        };

        // Add js and css urls to cropper.js
        config.cropperJsUrl = "https://cdnjs.cloudflare.com/ajax/libs/cropperjs/1.5.13/cropper.min.js";
        config.cropperCssUrl = "https://cdnjs.cloudflare.com/ajax/libs/cropperjs/1.5.13/cropper.min.css"
    };
```
