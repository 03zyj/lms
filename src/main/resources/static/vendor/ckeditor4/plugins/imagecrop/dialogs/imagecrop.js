CKEDITOR.dialog.add('cropDialog', function (editor) {
    let options = editor.config.cropperOption;
    let selectedElement = editor.getSelection().getSelectedElement();
    let width = parseInt(window.innerWidth * 80 / 100);
    let height = parseInt(window.innerHeight * 80 / 100);
    let cropper;
    return {
        title: 'Crop Image',
        width: width,
        height: height,
        contents: [
            {
                id: 'tab1',
                label: editor.lang.imagecrop.cropTab,
                elements: [
                    {
                        id: 'crop-image',
                        type: 'html',
                        html: '<img src="' + selectedElement.$.src + '">',
                        style: 'display:block;margin:0px auto; max-width: 100%; max-height: ' + parseInt(window.innerHeight * 80 / 100) + 'px; border-color:#CECECE',
                        setup: function(element) {
                            cropper = new Cropper(element, options);
                        }
                    }
                ]
            },
        ],
        onShow: function () {
            let img = this.getContentElement('tab1', 'crop-image');
            this.setupContent(document.getElementById(img.domId));
        },
        onOk: function() {
            // Upload cropped image to server if the browser supports `HTMLCanvasElement.toBlob`.
            // The default value for the second parameter of `toBlob` is 'image/png', change it if necessary.
            //cropper.getCroppedCanvas().toBlob(function (blob){
            cropper.getCroppedCanvas().toBlob(function (blob) {
                const formData = new FormData();
                // Pass the image file name as the third parameter if necessary.
                formData.append('upload', blob/*, 'example.png' */);
                const loadingIndexForCropImage = layer.load(1);
                // Use `jQuery.ajax` method for example
                $.ajax(editor.config.uploadUrl, {
                    method: 'POST',
                    data: formData,
                    processData: false,
                    contentType: false,
                    success(result) {
                        let originImage = $('#' + selectedElement.$.id);
                        originImage.attr("src", result.url);
                        originImage.attr("data-cke-saved-src", result.url);
                        cropper.destroy();
                        layer.close(loadingIndexForCropImage);
                        CKEDITOR.dialog.getCurrent().hide();
                        $("html,body").animate({scrollTop: originImage.offset().top - 100}, 1000);
                        layer.msg('图片剪裁完成，记得点击「保存」入库');
                    },
                    error(xhr) {
                        console.log(xhr);
                    },
                });
            }/*, 'image/png' */);

            return false;
        }
    };
});
