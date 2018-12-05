<#macro table>
                    <table class="table table-striped table-bordered" cellspacing="0" width="100%" id="proxylisttable"
                           >
                        <thead>
                        <tr>
                            <th>IP Address</th>
                            <th>Port</th>
                            <th>Code</th>
                            <th>Version</th>
                            <th class='hm'>Anonymity</th>
                            <th class='hm'>Https</th>
                            <th class='hd'>Last Checked</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list proxysocks as proxysocks>
                        <tr>
                            <td>${proxysocks.proxy}</td>
                            <td>${proxysocks.port}</td>
                            <td>${proxysocks.code}</td>
                            <td>${proxysocks.type}</td>
                            <td class='hm'>Anonymous</td>
                            <td class='hm'>Yes!!!</td>
                            <td class='hd'>6 seconds ago!!!</td>
                        </tr>
                        </#list>
                        </tbody>
                        <tfoot>
                        <tr>
                            <th class="input"><input type="text"/></th>
                            <th></th>
                            <th></th>
                            <th class='hm'></th>
                            <th></th>
                            <th class='hm'></th>
                            <th class='hd'></th>
                        </tr>
                        </tfoot>
                    </table>
</#macro>