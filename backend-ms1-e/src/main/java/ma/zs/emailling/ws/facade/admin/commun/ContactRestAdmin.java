package  ma.zs.emailling.ws.facade.admin.commun;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.emailling.bean.core.commun.Contact;
import ma.zs.emailling.dao.criteria.core.commun.ContactCriteria;
import ma.zs.emailling.service.facade.admin.commun.ContactAdminService;
import ma.zs.emailling.ws.converter.commun.ContactConverter;
import ma.zs.emailling.ws.dto.commun.ContactDto;
import ma.zs.emailling.zynerator.controller.AbstractController;
import ma.zs.emailling.zynerator.dto.AuditEntityDto;
import ma.zs.emailling.zynerator.util.PaginatedList;


import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ma.zs.emailling.zynerator.process.Result;


import org.springframework.web.multipart.MultipartFile;
import ma.zs.emailling.zynerator.dto.FileTempDto;

@RestController
@RequestMapping("/api/admin/contact/")
public class ContactRestAdmin  extends AbstractController<Contact, ContactDto, ContactCriteria, ContactAdminService, ContactConverter> {



    @Operation(summary = "upload one contact")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple contacts")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all contacts")
    @GetMapping("")
    public ResponseEntity<List<ContactDto>> findAll() throws Exception {
        return super.findAll();
    }



    @Operation(summary = "Saves the specified  contact")
    @PostMapping("")
    public Contact save(@RequestBody Contact contact) throws Exception {
        return service.save(contact);
    }

    @Operation(summary = "Updates the specified  contact")
    @PutMapping("")
    public ResponseEntity<ContactDto> update(@RequestBody ContactDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of contact")
    @PostMapping("multiple")
    public ResponseEntity<List<ContactDto>> delete(@RequestBody List<ContactDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified contact")
    @DeleteMapping("")
    public ResponseEntity<ContactDto> delete(@RequestBody ContactDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified contact")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple contacts by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by personneSource id")
    @GetMapping("personneSource/id/{id}")
    public List<ContactDto> findByPersonneSourceId(@PathVariable Long id){
        return findDtos(service.findByPersonneSourceId(id));
    }
    @Operation(summary = "delete by personneSource id")
    @DeleteMapping("personneSource/id/{id}")
    public int deleteByPersonneSourceId(@PathVariable Long id){
        return service.deleteByPersonneSourceId(id);
    }
    @Operation(summary = "find by personneDestination id")
    @GetMapping("personneDestination/id/{id}")
    public List<ContactDto> findByPersonneDestinationId(@PathVariable Long id){
        return findDtos(service.findByPersonneDestinationId(id));
    }
    @Operation(summary = "delete by personneDestination id")
    @DeleteMapping("personneDestination/id/{id}")
    public int deleteByPersonneDestinationId(@PathVariable Long id){
        return service.deleteByPersonneDestinationId(id);
    }

    @Operation(summary = "Finds a contact and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<ContactDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds contacts by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<ContactDto>> findByCriteria(@RequestBody ContactCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated contacts by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody ContactCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports contacts by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody ContactCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets contact data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody ContactCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public ContactRestAdmin (ContactAdminService service, ContactConverter converter) {
        super(service, converter);
    }




}
