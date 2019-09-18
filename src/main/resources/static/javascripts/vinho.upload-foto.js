$(() => {

    if (!document.querySelector("#upload-drop")) return

    var progressbar = $("#progressbar"),
        bar = progressbar.find('.uk-progress-bar'),
        containerFoto = $('.js-container-foto'),
        settings = {
            type: 'json',

            filelimit: 1,

            action: '/fotos/' + document.querySelector("#upload-drop").getAttribute('data-codigo'), // upload url

            allow: '*.(jpg|jpeg|png)', // allow only images

            beforeSend: (xhr) => {
                let header = $('input[name=_csrf_header]').val()
                let token = $('input[name=_csrf]').val()
                xhr.setRequestHeader(header, token)
            },

            loadstart: function () {
                bar.css("width", "0%").text("0%")
                progressbar.removeClass("uk-hidden")
            },

            progress: function (percent) {
                percent = Math.ceil(percent)
                bar.css("width", percent + "%").text(percent + "%");
            },

            complete: function (foto) {
                containerFoto.prepend('<img src="' + foto.url + '">')
                $("#upload-drop").addClass('hidden')
            }
        }

    var select = UIkit.uploadSelect($("#upload-select"), settings),
        drop = UIkit.uploadDrop($("#upload-drop"), settings)
})