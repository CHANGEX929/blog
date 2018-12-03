<!--进度条-->
<div class="modal fade" id="programBar" tabindex="-1" role="dialog" data-backdrop="false" data-keyboard="false">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div align=center width="100%" height="100%" id="cycle">
                <p><span id="shclFireballs" class="red" style="font-size:50px;"></span></p>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<script>
    $(function () {
        $('#cycle').shCircleLoader({
            color: "red",
            dots: 24,
            dotsRadius: 13,
            keyframes:
                    "0%   {background: red;    {prefix}transform: scale(1)}\
                     20%  {background: orange; {prefix}transform: scale(.4)}\
                     40%  {background: red;    {prefix}transform: scale(0)}\
                     50%  {background: red;    {prefix}transform: scale(1)}\
                     70%  {background: orange; {prefix}transform: scale(.4)}\
                     90%  {background: red;    {prefix}transform: scale(0)}\
                     100% {background: red;    {prefix}transform: scale(1)}"
        });
    })
</script>