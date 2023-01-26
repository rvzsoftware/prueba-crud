import logging
from odoo import models, fields

_logger = logging.getLogger(__name__)

class crud(models.Model):
    _name = "crud"
    
    
    name = fields.Char('Nombre', required=True)
    mobile_phone = fields.Char('Teléfono Celular', size=128)
    work_email = fields.Char('Email', size=128)
    identification_id = fields.Char('RFC', requiered=True, size=128)
    observ = fields.Char('Observaciones', size=128)
    state = fields.Selection([('draft', 'Documento borrador'),
                              ('process', 'Proceso'),
                              ('done', 'Egresado'),
                              ('cancel', 'Expulsado')],
                             'Estado', default='draft')
    
    
    def write (self,values):
        res = super (crud, self).write(values)
         
        if 'name' in values.keys():
            for emp in self:
                if emp.user_id:
                    emp.user_id.write({'name': emp.name})
            _logger.info(
                "Se a modificado el nombre a: ".format(values))
        
        if 'mobile_phone' in values.keys():
            for emp in self:
                if emp.phone_id:
                   emp.phone_id.write({'mobile_phone': emp.phone})
         
        
        if 'work_email' in values.keys():
            for emp in self:
                if emp.email_id:
                   emp.email_id.write({'work_email': emp.email})
            
            
        if 'identificaction_id' in values.keys():
            for emp in self:
                if emp.rfc_id:
                   emp.rfc_id.write({'mobile_phone': emp.rfc})
        
    
            
        return res