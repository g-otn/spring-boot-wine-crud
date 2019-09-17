$(() => {
    var progressbar = $("#progressbar"),
        bar = progressbar.find('.uk-progress-bar'),
        settings = {
            type: 'json',

            filelimit: 1,

            action: '/fotos/' + document.querySelector('#upload-drop').getAttribute('data-codigo'), // upload url

            allow: '*.(jpg|jpeg|png)', // allow only images

            loadstart: function () {
                bar.css("width", "0%").text("0%")
                progressbar.removeClass("uk-hidden")
            },

            progress: function (percent) {
                percent = Math.ceil(percent)
                bar.css("width", percent + "%").text(percent + "%")
            },

            complete: function (foto) {

                bar.css("width", "100%").text("100%")

                setTimeout(function () {
                    progressbar.addClass("uk-hidden")
                }, 250)

                console.log("Upload completo! Foto:", foto.nome)
            }
        }

    var select = UIkit.uploadSelect($("#upload-select"), settings),
        drop = UIkit.uploadDrop($("#upload-drop"), settings)
})