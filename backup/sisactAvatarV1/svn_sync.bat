@echo on
echo Iniciando

echo ***************************************************************************
echo ======================= Actualizando svn ======================= 
echo ***************************************************************************
call svn update X:\Unidad_X\DUMMY\ServiceConsultaOrdenesClaroAvatar
call svn update X:\Unidad_X\DUMMY\ServiceCulqiConsultarOrdenClaroAvatar
call svn update X:\Unidad_X\DUMMY\ServiceCulqiCrearCargoClaroAvatar
call svn update X:\Unidad_X\DUMMY\ServiceEvaluaOrdenClaroAvatar2
call svn update X:\Unidad_X\DUMMY\ServicePRSSmsClaroAvatar
call svn update X:\Unidad_X\DUMMY\ServicePRSValidacionClaroAvatar
call svn update X:\Unidad_X\DUMMY\ServiceValidarCompraClaroAvatar
call svn update X:\Unidad_X\DUMMY\sisactAvatar
